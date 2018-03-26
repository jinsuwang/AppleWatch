package com.samjin.segmenttree;

import javax.swing.text.Segment;

public class RangeSumQuery {


    private class SegmentTreeNode{
        int start, end;

        SegmentTreeNode left, right;
        int sum;

        SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            sum = 0;
        }
    }

    SegmentTreeNode root = null;

    private SegmentTreeNode build(int[] arr, int start, int end){
        if(end < start) return null;
        SegmentTreeNode ret = new SegmentTreeNode(start,end);
        if(start == end) ret.sum = arr[start];
        else{
            int mid = start + ( end - start ) / 2;
            ret.left = build(arr, start, mid);
            ret.right = build(arr, mid+1, end);
            ret.sum = ret.left.sum + ret.right.sum;
        }
        return ret;
    }

    public RangeSumQuery(int[] nums) {
        root = build(nums,0, nums.length - 1);
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) return root.sum;
        else{
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid){
                return sumRange(root.left, start, end);
            }else if (start >= mid + 1){
                return sumRange(root.right, start, end);
            }
            else{
                return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
            }
        }
    }

    private void update(SegmentTreeNode root, int pos, int val){
        if (root.start == root.end){
            root.sum = val;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (pos <= mid) update(root.left, pos, val);
        else update(root.right, pos, val);

        root.sum = root.left.sum + root.right.sum;

    }
}
