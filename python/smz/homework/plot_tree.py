# coding=UTF-8
import matplotlib.pyplot as plt
decisionNode = dict(boxstyle="sawtooth", fc="0.8")
leafNode = dict(boxstyle="round4", fc="0.8")
arrow_args = dict(arrowstyle="<-")


def plotNode(Nodename, centerPt, parentPt, nodeType):
    creatPlot.ax1.annotate(Nodename, xy=parentPt,
                           xycoords='axes fraction',
                           xytext=centerPt,
                           textcoords='axes fraction',
                           va="center", ha="center", bbox=nodeType, arrowprops=arrow_args)


# def creatPlot():
#     fig = plt.figure(1, facecolor='white')
#     fig.clf()
#     creatPlot.ax1 = plt.subplot(111,frameon=False)
#     plotNode(U'decision Node', (0.5,0.1), (0.1,0.5), decisionNode)
#     plotNode(U'leaf Node', (0.8,0.1), (0.3,0.8), leafNode)
#     plt.show()


def getNumleafs(mytree):
    Numleafs = 0
    firstStr = list(mytree.keys())[0]
    secondDict = mytree[firstStr]
    for key in secondDict.keys():
        if type(secondDict[key]).__name__=='dict':
            Numleafs += getNumleafs(secondDict[key])
        else:
            Numleafs += 1
    return Numleafs

def getTreeDepth(mytree):
    maxDepth = 0
    thisDepth = 0
    firstStr = list(mytree.keys())[0]
    secondDict = mytree[firstStr]
    for key in secondDict.keys():
        if type(secondDict[key]).__name__=='dict':
            thisDepth += getTreeDepth(secondDict[key])
        else:
            thisDepth = 1
        if thisDepth > maxDepth:
            maxDepth = thisDepth
    return maxDepth


def retrieveTree(i):
    listOfTrees =[{'no surfacing': {0: 'no', 1: {'flippers': {0: 'no', 1: 'yes'}}}},
    {'no surfacing': {0: 'no', 1: {'flippers': {0: {'head': {0: 'no', 1: 'yes'}}, 1: 'no'}}}}
    ]
    return listOfTrees[i]


def plotMidText(cntrPt, parentPt, txtString):
    xMid = (parentPt[0]-cntrPt[0])/2.0 + cntrPt[0]
    yMid = (parentPt[1]-cntrPt[1])/2.0 + cntrPt[1]
    creatPlot.ax1.text(xMid, yMid, txtString)


def plotTree(myTree, parentPt, nodeName):
    numleafs = getNumleafs(myTree)
    depth = getTreeDepth(myTree)
    firstStr = list(myTree.keys())[0]
    cntrPt = (plotTree.xOff+(0.5/plotTree.totalw+float(numleafs)/2.0/plotTree.totalw), plotTree.yOff)
    plotMidText(cntrPt, parentPt, nodeName)
    plotNode(firstStr, cntrPt, parentPt, decisionNode)
    secondDict = myTree[firstStr]
    plotTree.yOff = plotTree.yOff - 1.0/(plotTree.totalD or 1)
    for key in secondDict.keys():
        if type(secondDict[key]).__name__=='dict':
            plotTree(secondDict[key], cntrPt, str(key))
        else:
            plotTree.xOff = plotTree.xOff + 1.0/plotTree.totalw
            plotNode(secondDict[key], (plotTree.xOff, plotTree.yOff), cntrPt, leafNode)
            plotMidText((plotTree.xOff, plotTree.yOff), cntrPt, str(key))
    plotTree.yOff = plotTree.yOff + 1.0/(plotTree.totalD or 1)

def creatPlot(inTree):
    fig = plt.figure(1, facecolor='white')
    fig.clf()
    axprops = dict(xticks=[], yticks=[])
    creatPlot.ax1 = plt.subplot(111, frameon=False, **axprops)
    plotTree.totalw = float(getNumleafs(inTree))
    plotTree.totalD = float(getTreeDepth(inTree))
    plotTree.xOff = -0.5/plotTree.totalw
    plotTree.yOff = 1.0
    plotTree(inTree, (0.5,1.0), '')
    plt.show()





if __name__ == '__main__':
    myTree = retrieveTree(0)
    print getNumleafs(myTree)
    print getTreeDepth(myTree)
    creatPlot(myTree)