package com.snippet.ds.trie;

/**
 * create by whr on 2023-07-15
 */
class TrieNode {
    private TrieNode[] links;
    private boolean isEnd;

    public TrieNode() {
        int r = 26;
        links = new TrieNode[r];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
