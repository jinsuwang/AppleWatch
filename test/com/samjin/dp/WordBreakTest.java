package com.samjin.dp;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordBreakTest {

    List<String> workDict;
    WordBreak ins;

    @Before
    public void setup(){
        workDict = Arrays.asList(new String[]{"leet","code"});
    }

    @Test
    public void e2e(){
        ins = new WordBreak();
        System.out.println(ins.wordBreak("leetcode", workDict));
    }

}