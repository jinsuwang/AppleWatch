package com.samjin.bfs;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.equals(endWord)) return 0;

        Set<String> wordDict = new HashSet<>(wordList);

        // 如果 endWord 不在 wordDict 中，直接返回 0
        if (!wordDict.contains(endWord)) return 0;

        Queue<String> wordQueue = new LinkedList<>();
        Queue<Integer> disQueue = new LinkedList<>();

        wordQueue.add(beginWord);
        disQueue.add(1);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!wordQueue.isEmpty()) {
            String currWord = wordQueue.poll();
            int dist = disQueue.poll();

            for (int i = 0; i < currWord.length(); i++) {
                char[] currCharArr = currWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    currCharArr[i] = c;
                    String newWord = new String(currCharArr);

                    // 跳过已经访问过的单词
                    if (visited.contains(newWord)) continue;

                    // 如果 newWord 在字典中且未访问过
                    if (wordDict.contains(newWord)) {
                        if (newWord.equals(endWord)) return dist + 1;

                        wordQueue.add(newWord);
                        disQueue.add(dist + 1);
                        visited.add(newWord);  // 标记 newWord 为已访问
                    }
                }
            }
        }

        return 0;
    }
}
