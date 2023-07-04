package com.snippet.javacodebase.collections;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * TreeMap实现一致性hash
 * <p>
 * create by whr on 2023-06-14
 */
public class TreeMapAPI {

    private static final TreeMap<Integer, String> hashCircle = new TreeMap<>();

    public static void main(String[] args) {
        // 添加节点
        hashCircle.put(1, "node1");
        hashCircle.put(5, "node2");
        hashCircle.put(7, "node3");
        hashCircle.put(9, "node4");

        // 计算hash
        int key = 1231231;
        int hash = hash(key);

        // 找到最近的节点node
        // sortedMap: 5, 7, 9
        // tailMap:取出红黑树指定节点的右子树
        SortedMap<Integer, String> sortedMap = hashCircle.tailMap(hash);
        Integer node = sortedMap.firstKey();

        if (null == node) {
            System.out.println("Nearest node: " + hashCircle.get(hashCircle.firstKey()));
        }
        System.out.println("Nearest node: " + hashCircle.get(node));
    }

    private static int hash(int key) {
        return key % hashCircle.size();
    }
}
