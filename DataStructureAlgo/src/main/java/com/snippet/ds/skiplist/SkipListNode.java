package com.snippet.ds.skiplist;

/**
 * create by whr on 2023-07-15
 */
public class SkipListNode {

    int key;
    int value;
    int score;
    SkipListNode[] forward;

    public SkipListNode(int score, int maxLevel) {
        this.score = score;
        this.forward = new SkipListNode[maxLevel];
    }
}
