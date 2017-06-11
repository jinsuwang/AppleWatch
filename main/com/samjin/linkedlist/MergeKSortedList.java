package com.samjin.linkedlist;

import com.samjin.util.ListNode;

import java.util.List;

/**
 * Created by sjjin on 6/5/17.
 */
public class MergeKSortedList {

    public ListNode merge( List<ListNode> lists ){
        if( lists.size() == 0 ) return null;
        return mergeHelper( lists, 0, lists.size() - 1 );
    }

    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if( start >= end ){
            return lists.get(start);
        }

        int mid = start + ( end - start ) / 2;

        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);

        return mergeTwoList( left, right );
    }

    private ListNode mergeTwoList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        ListNode p1 = left;
        ListNode p2 = right;

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
}
