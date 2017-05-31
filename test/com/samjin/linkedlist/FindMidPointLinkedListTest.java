package com.samjin.linkedlist;

import com.samjin.util.ListNode;
import com.samjin.util.TestFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sjjin on 5/30/17.
 */
public class FindMidPointLinkedListTest {

    private ListNode head;

    @Before
    public void setUp() throws Exception {
        head = TestFactory.getNormalLinkedlist();
    }

    @Test
    public void TestfindMidPointLinkedList() throws Exception {
        Assert.assertEquals(4, FindMidPointLinkedList.findMidPointLinkedList(head));
    }

}