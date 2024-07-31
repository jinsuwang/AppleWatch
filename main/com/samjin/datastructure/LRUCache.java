package com.samjin.datastructure.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private class Node {

        public Node next;
        public Node prev;
        public Integer key ;
        public Integer val;

        Node(Integer key, Integer val){
            this.key = key;
            this.val = val;
            next = null;
            prev = null;
        }
    }
    private int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node curr = map.get(key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        moveToTail(curr);
        return (int)curr.val;
    }

    private void moveToTail(Node node) {
        Node tmp = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
        node.prev = tmp;
    }

    public void put(int key, int value) {
        if( get(key) != -1 ){
            map.get(key).val = value;
            return;
        }

        // Map is full, remove least used item
        if(map.size() == capacity){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        moveToTail(newNode);
    }
}
