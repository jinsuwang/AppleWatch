package com.samjin.design.worddictionary;

public class WordDictionary {

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;

        TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }
    }

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode curr = root;
        if (word == null || word.length() == 0) return;

        for (int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }

        curr.isWord = true;
        curr.word = word;
    }

    public boolean search(String word) {
        return search(word, root, 0);
    }

    public boolean search(String word, TrieNode root, int index){
        if (root == null) return false;
        if (index == word.length()) return root.isWord;

        if (word.charAt(index) == '.'){
            for (TrieNode c: root.children){
                if (search(word, c, index+1)){
                    return true;
                }
            }
        } else{
            int tmpIndex = word.charAt(index) - 'a';
            TrieNode tmp = root.children[tmpIndex];
            return search(word, tmp, index+1);
        }
        return false;
    }
}
