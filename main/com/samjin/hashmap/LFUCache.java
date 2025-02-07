package com.samjin.hashmap;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Node> keyToNode;
    private final Map<Integer, LinkedHashSet<Node>> freqToNodes;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToNode = new HashMap<>();
        this.freqToNodes = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) return -1;
        Node node = keyToNode.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (keyToNode.size() >= capacity) {
                removeLFU();
            }
            Node newNode = new Node(key, value);
            keyToNode.put(key, newNode);
            freqToNodes.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(newNode);
            minFreq = 1;
        }
    }

    private void updateFreq(Node node) {
        int freq = node.freq;
        freqToNodes.get(freq).remove(node);
        if (freqToNodes.get(freq).isEmpty()) {
            freqToNodes.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }

        node.freq++;
        freqToNodes.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node);
    }

    private void removeLFU() {
        LinkedHashSet<Node> nodes = freqToNodes.get(minFreq);
        Node toRemove = nodes.iterator().next();
        nodes.remove(toRemove);
        if (nodes.isEmpty()) {
            freqToNodes.remove(minFreq);
        }
        keyToNode.remove(toRemove.key);
    }

    private class Node {
        int key, value, freq;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
}
