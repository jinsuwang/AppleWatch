package com.samjin.bfs;

import com.samjin.bfs.WordLadder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordLadderTest {

    WordLadder ins = new WordLadder();

    @Test
    public void ladderLength() {

        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        String beginWord = "hit";
        String endWord = "cog";
        int res = ins.ladderLength(beginWord, endWord, wordList);
        System.out.println(res);

    }
}