import numpy as np
import operator
import plot_tree as pt
import pandas as pd
import copy
from sklearn.model_selection import train_test_split
import re


def cal(data_set):
    count = len(data_set)
    label_dic = {}
    for feat in data_set:
        current_label = feat[-1]
        if current_label not in label_dic.keys():
            label_dic[current_label] = 0
        label_dic[current_label] += 1
    entropy = 0.0
    for key in label_dic:
        prob = float(label_dic[key]) / count
        entropy -= prob * np.math.log(prob, 2)
    return entropy


def split_data(data_set, attr, value):
    ret = []
    for feat in data_set:
        if feat[attr] == value:
            reduced_feat = feat[:attr].tolist()
            reduced_feat.extend(feat[attr+1:].tolist())
            ret.append(np.array(reduced_feat))
    return ret


def chose_to_split(data_set):
    count = len(data_set[0]) - 1
    base_entropy = cal(data_set)
    best_infogain = 0.0
    best_feat = -1
    for i in range(count):
        feat_list = [example[i] for example in data_set]
        unique_vals = set(feat_list)
        new_entropy = 0.0
        for value in unique_vals:
            sub_data_set = split_data(data_set, i, value)
            prob = len(sub_data_set) / float(len(data_set))
            new_entropy += prob * cal(sub_data_set)
        infogain = base_entropy - new_entropy
        if infogain > best_infogain:
            best_infogain = infogain
            best_feat = i
    return best_feat


def majority_vote(class_list):
    class_count = {}
    for vote in class_list:
        if vote not in class_count.keys():
            class_count[vote] = 0
        class_count[vote] += 1
    sorted_class_count = sorted(class_count.items(), key=operator.itemgetter(1), reverse=True)
    return sorted_class_count[0][0]


def create_tree(data_set, labels):
    class_list = [example[-1] for example in data_set]
    if class_list.count(class_list[0]) == len(class_list):
        return class_list[0]
    if len(data_set[0]) == 1:
        return majority_vote(class_list)
    best_feat = chose_to_split(data_set)
    best_feat_label = labels[best_feat]
    my_tree = {best_feat_label : {}}
    # del(labels[best_feat])
    feat_values = [example[best_feat] for example in data_set]
    unique_vals = set(feat_values)
    for value in unique_vals:
        sub_labels = labels[:]
        my_tree[best_feat_label][value] = create_tree(split_data(data_set, best_feat, value), sub_labels)
    return my_tree



def classify(input_tree, featAttributes, test_vec):
    first_str = list(input_tree.keys())[0]
    second_dic = input_tree[first_str]
    feat_index = featAttributes.index(first_str)
    key = test_vec[feat_index]
    value = second_dic[key]
    if isinstance(value, dict):
        class_label = classify(value, featAttributes, test_vec)
    else:
        class_label = value
    return class_label


def cut_data(df):
    cut_num = 3
    df[0] = pd.cut(df[0], cut_num)
    df[1] = pd.cut(df[1], cut_num)
    df[2] = pd.cut(df[2], cut_num)
    return df

# def postPruningTree(inputTree,dataSet,data_test,labels):
#     firstStr=inputTree.keys()[0]
#     print "_"*100
#     print inputTree
#     print "_" * 100
#     secondDict=inputTree[firstStr]
#     classList=[example[-1] for example in dataSet]
#     featkey=copy.deepcopy(firstStr)
#
#     return majorityCnt(classList)



if __name__ == '__main__':
    df = pd.read_csv('3.csv', sep='\s+', header=None)
    df = cut_data(df)
    train, test = train_test_split(df.values, test_size=0.15, random_state=2)
    feature_train = test[:, :3]
    label_train = test[:, 3].astype(int)
    feature_test = test[:, :3]
    label_test = test[:, 3].astype(int)

    tree = create_tree(train, label_train)
    # print tree
    pt.creatPlot(tree)