package com.snippet.ds.skiplist;

/**
 * create by whr on 2023-07-15
 */
public class App {
    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.add(30);
        skipList.add(40);
        skipList.add(50);
        skipList.add(60);
        skipList.add(12);
        skipList.add(21);
        skipList.add(58);
        skipList.add(19);
        skipList.add(31);
        skipList.add(71);
        skipList.add(26);
        skipList.add(90);
        skipList.search(50);
    }
}
