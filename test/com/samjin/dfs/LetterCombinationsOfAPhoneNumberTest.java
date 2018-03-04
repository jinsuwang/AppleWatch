package com.samjin.dfs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LetterCombinationsOfAPhoneNumberTest {

    LetterCombinationsOfAPhoneNumber ins = new LetterCombinationsOfAPhoneNumber();

    @Test
    public void letterCombinations() {
        String input = "23";
        System.out.println(ins.letterCombinations(input));
    }
}