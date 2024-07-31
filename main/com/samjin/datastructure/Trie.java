package com.samjin.datastructure;

import com.samjin.tree.TreeNode;

public class Trie {

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;

        public TrieNode(){
            children = new TrieNode[26];
            isWord = false;
            word = "";
        }
    }

    private TrieNode root;



    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null) return false;
            node = node.children[index];
        }

        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(node.children[index] == null) return false;
            node = node.children[index];
        }
        return true;
    }
}
