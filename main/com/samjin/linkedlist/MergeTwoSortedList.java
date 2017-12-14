package com.samjin.linkedlist;

import com.samjin.util.ListNode;

/**
 * Created by sjjin on 6/5/17.
 */
public class MergeTwoSortedList {

    public ListNode merge(ListNode l1, ListNode l2){

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        ListNode p1 = l1;
        ListNode p2 = l2;

        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                curr.next = p1;
                p1 = p1.next;
            }else{
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }

        if( p1 == null ) curr.next = p2;
        if( p2 == null ) curr.next = p1;

        return dummy.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {

        if( lists == null || lists.length == 0 ) return null;

        return mergeKLists(lists, 0, lists.length - 1);

    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end ){

        if( start >= end ) return lists[start];

        int mid = start + (end - start) / 2;

        ListNode left = mergeKLists( lists, start, mid );
        ListNode right = mergeKLists( lists, mid+1, end);

        return merge(left,right);

    }
}
