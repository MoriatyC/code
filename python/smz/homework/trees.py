from plot_tree import *
from math import log
import pandas as pd
from sklearn.model_selection import train_test_split


def createDataSet():
    dataSet = [[1, 1, 'yes'],
               [1, 1, 'yes'],
               [1, 0, 'no'],
               [0, 1, 'no'],
               [0, 1, 'no']]
    attributes = ['no surfacing','flippers']
    #change to discrete values
    return dataSet, attributes

def calcEnt(dataSet):
    numEntries = len(dataSet)
    labelCounts = {}
    for featVec in dataSet: #the the number of unique elements and their occurance
        currentLabel = featVec[-1]
        if currentLabel not in labelCounts.keys():
            labelCounts[currentLabel] = 0
            labelCounts[currentLabel] += 1
        else:
            labelCounts[currentLabel] += 1
    ent = 0.0
    for key in labelCounts:
        prob = float(labelCounts[key])/numEntries
        ent -= prob * log(prob,2) 
    return ent
    
def splitDataSet(dataSet, attr, value):
    retDataSet = []
    for featVec in dataSet:
        if featVec[attr] == value:
            reducedFeatVec = featVec[:attr]     #chop out axis used for splitting
            reducedFeatVec.extend(featVec[attr+1:])
            retDataSet.append(reducedFeatVec)
    return retDataSet
    
def chooseBestFeatureToSplit(dataSet):
    numFeatures = len(dataSet[0]) - 1      #the last column is used for the labels
    baseEntropy = calcEnt(dataSet)
    bestInfoGain = 0.0; bestFeature = -1
    for i in range(numFeatures):        #iterate over all the features
        featList = [example[i] for example in dataSet]#create a list of all the examples of this feature
        uniqueVals = set(featList)       #get a set of unique values
        newEntropy = 0.0
        for value in uniqueVals:
            subDataSet = splitDataSet(dataSet, i, value)
            prob = len(subDataSet)/float(len(dataSet))
            newEntropy += prob * calcEnt(subDataSet)     
        infoGain = baseEntropy - newEntropy     #calculate the info gain; ie reduction in entropy
        if (infoGain > bestInfoGain):       #compare this to the best gain so far
            bestInfoGain = infoGain         #if better than current best, set to best
            bestFeature = i
    return bestFeature                      #returns an integer

def majorityCnt(classList):
    classCount={}
    for vote in classList:
        if vote not in classCount.keys():
            classCount[vote] = 0
        classCount[vote] += 1
    sortedClassCount = sorted(classCount.items(), key=lambda itemLabel:itemLabel[1], reverse=True)
    return sortedClassCount[0][0]

def createTree(dataSet,attributes):
    classList = [example[-1] for example in dataSet]
    if classList.count(classList[0]) == len(classList): 
        return classList[0]#stop splitting when all of the classes are equal
    if len(dataSet[0]) == 1: #stop splitting when there are no more features in dataSet
        return majorityCnt(classList)
    bestFeat = chooseBestFeatureToSplit(dataSet)
    bestFeatLabel = attributes[bestFeat]
    myTree = {bestFeatLabel:{}}
    del(attributes[bestFeat])
    featValues = [example[bestFeat] for example in dataSet]
    uniqueVals = set(featValues)
    for value in uniqueVals:
        subAttributes = attributes[:]       #copy all of attributes, so trees don't mess up existing attributes
        myTree[bestFeatLabel][value] = createTree(splitDataSet(dataSet, bestFeat, value),subAttributes)
    return myTree                            
    
def classify(inputTree,featAttributes,testVec):
    firstStr = list(inputTree.keys())[0]
    secondDict = inputTree[firstStr]
    featIndex = featAttributes.tolist().index(firstStr)
    key = testVec[featIndex]
    valueOfFeat = secondDict[key]
    if isinstance(valueOfFeat, dict): 
        classLabel = classify(valueOfFeat, featAttributes, testVec)
    else: classLabel = valueOfFeat
    return classLabel


def storeTree(inputTree,filename):
    import pickle
    fw = open(filename,'wb')
    pickle.dump(inputTree,fw)
    fw.close()
    
def grabTree(filename):
    import pickle
    fr = open(filename, 'rb')
    return pickle.load(fr)

def cut_data(df):
    cut_num = 3
    df[0] = pd.cut(df[0], cut_num)
    df[1] = pd.cut(df[1], cut_num)
    df[2] = pd.cut(df[2], cut_num)
    return df


df = pd.read_csv('3.csv', sep='\s+', header=None)
df = cut_data(df)
train, test = train_test_split(df.values, test_size=0.15, random_state=2)
feature_train = test[:, :3]
label_train = test[:, 3].astype(int)
print type(label_train.tolist())
feature_test = test[:, :3]
label_test = test[:, 3].astype(int)
tree = createTree(train.tolist(), label_train.tolist())
print creatPlot(tree)