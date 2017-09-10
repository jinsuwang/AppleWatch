package com.samjin.linkedlist;

import com.samjin.util.ListNode;
import com.samjin.util.MyPrinter;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sjjin on 8/25/17.
 */
public class AddTwoNumberTest {

    private AddTwoNumber instance = new AddTwoNumber();
    private ListNode l1;
    private ListNode n1;


    @Before
    public void setUp(){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(6);
        ListNode n3 = new ListNode(4);

        l1.next = l2;l2.next = l3;
        n1.next = n2;n2.next = n3;
    }

    @Test
    public void addTwoNumbers() throws Exception {

        MyPrinter.printLinkedlist(l1);
        MyPrinter.printLinkedlist(n1);

        ListNode res = instance.addTwoNumbers(l1,n1);
        MyPrinter.printLinkedlist(res);

    }
}
