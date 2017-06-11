package com.samjin.linkedlist;

import com.samjin.util.ListNode;
import com.samjin.util.MyPrinter;
import com.samjin.util.TestFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by sjjin on 6/5/17.
 */
public class MergeKSortedListTest {
    @Test
    public void merge() throws Exception {

        MergeKSortedList driver = new MergeKSortedList();

        ListNode l1 = TestFactory.getNormalLinkedlist();
        ListNode l2 = TestFactory.getNormalLinkedlist();
        ListNode l3 = TestFactory.getNormalLinkedlist();

        List<ListNode> lists = new ArrayList<>();
        lists.add(l1); lists.add(l2); lists.add(l3);

        ListNode res = driver.merge(lists);
        MyPrinter.printLinkedlist(res);

    }

}