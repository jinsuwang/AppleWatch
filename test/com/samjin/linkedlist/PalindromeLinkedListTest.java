package com.samjin.linkedlist;

import com.samjin.util.ListNode;
import com.samjin.util.TestFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeLinkedListTest {

    PalindromeLinkedList ins = new PalindromeLinkedList();


    @Test
    public void isPalindrome() {
        ListNode l1 = TestFactory.getPalindroneLinkedlist();

        System.out.println(ins.isPalindrome(l1));
    }
}