package com.snippet.ds.trie;

/**
 * create by whr on 2023-07-15
 */
public class App {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("good");
        trie.insert("synchronized");
        boolean world = trie.search("world");
        System.out.println(world);
        boolean res = trie.search("synchronized");
        System.out.println(res);
    }
}
