package com.samjin.linkedlist;

import com.samjin.util.ListNode;
import com.samjin.util.MyPrinter;
import com.samjin.util.TestFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by sjjin on 6/5/17.
 */
public class MergeTwoSortedListTest {
    @Test
    public void merge() throws Exception {


        MergeTwoSortedList driver = new MergeTwoSortedList();

        ListNode l1 = TestFactory.getNormalLinkedlist();
        ListNode l2 = TestFactory.getNormalLinkedlist();

        ListNode res = driver.merge(l1,l2);

        MyPrinter.printLinkedlist(res);

    }

}