package com.snippet.algo.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * create by whr on 2023-07-14
 */
public class LRUCache {
    private int size;
    private final int capacity;
    private final Node head;
    private final Node tail;
    private final Map<Integer, Node> map;

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveNode(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            if (size == capacity) {
                // 删除尾节点
                Node pre = tail.pre;
                removeNode(tail.pre);
                map.remove(pre.key);
                --size;
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);
            ++size;

        } else {
            // 已经存在，更新value，并移到队首
            node.value = value;
            moveNode(node);
        }
    }

    private void moveNode(Node node) {
        //TODO: 维护链表,删除，再添加此节点到头部
        removeNode(node);
        addNode(node);
    }

    // 每次添加，到头部
    private void addNode(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void removeNode(Node node) {
        Node prev = node.pre;
        Node next = node.next;

        prev.next = next;
        next.pre = prev;
    }

}