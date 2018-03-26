package com.samjin.bfs;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(beginWord == null || endWord == null || beginWord.equals(endWord)) return 0;

        Queue<String> wordQueue = new LinkedList<>();
        Queue<Integer> disQueue = new LinkedList<>();

        wordQueue.add(beginWord);
        disQueue.add(1);
        Set<String> wordDict = new HashSet<>(wordList);


        while(!wordQueue.isEmpty()){
            String currWord = wordQueue.poll();
            int dist = disQueue.poll();
            for(int i = 0; i < currWord.length(); i++) {
                char[] currCharArr = currWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    currCharArr[i] = c;
                    String newWord = new String(currCharArr);
                    if(wordDict.contains(newWord)){
                        System.out.println("Enqueue: " + newWord);
                        if(newWord.equals(endWord)){
                            return dist+1;
                        }
                        wordQueue.add(newWord);
                        disQueue.add(dist+1);
                        wordDict.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
