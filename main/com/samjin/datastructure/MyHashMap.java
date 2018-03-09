package com.samjin.datastructure;

import java.util.ArrayList;
import java.util.Arrays;

public class MyHashMap<K,V> {

    private class LinkedListNode<K,V> {
        public LinkedListNode<K,V> prev;
        public LinkedListNode<K,V> next;

        public K key;
        public V value;

        public LinkedListNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<LinkedListNode<K,V>> arr;

    public MyHashMap(int capacity) {
        arr = new ArrayList<>();
        // initialize list with all Null.
        for(int i = 0; i < capacity; i++) {
            arr.add(null);
        }
    }

    public void put(K key, V value){
        LinkedListNode node = getNodeFromKey(key);
        if( node != null ){
            node.value = value;
            return;
        }
        // not exist before
        node = new LinkedListNode<K,V>(key, value);
        int index = getIndexFromKey(key);
        if(arr.get(index) != null){
            node.next = arr.get(index);
            node.next.prev = node;
        }
        arr.set(index,node);
    }

    public void remove(K key, V value){
        LinkedListNode<K,V> node = getNodeFromKey(key);

        if ( node == null ) return;

        // not at beginning
        if( node.prev != null ) {
            node.prev.next = node.next;
        }else{
            int index = getIndexFromKey(key);
            arr.set(index, node.next);
        }

        // handle next pointer
        if(node.next != null){
            node.next.prev = node.prev;
        }
    }

    private LinkedListNode getNodeFromKey(K key){
        int index = getIndexFromKey(key);
        LinkedListNode node = arr.get(index);
        while(node != null){
           if(node.key == key){
               return node;
           }
           node = node.next;
        }
        return null;
    }

    private int getIndexFromKey(K key){
        return Math.abs(key.hashCode() % arr.size());
    }
}
