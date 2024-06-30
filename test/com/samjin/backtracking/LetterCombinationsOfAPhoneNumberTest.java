package com.samjin.backtracking;

import org.junit.Test;

public class LetterCombinationsOfAPhoneNumberTest {

    LetterCombinationsOfAPhoneNumber ins = new LetterCombinationsOfAPhoneNumber();

    @Test
    public void letterCombinations() {
        String input = "23";
        System.out.println(ins.letterCombinations(input));
    }
}