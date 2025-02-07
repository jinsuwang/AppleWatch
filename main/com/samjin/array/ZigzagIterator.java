package com.samjin.array;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {

    private Queue<Iterator<Integer>> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (!v1.isEmpty()) queue.offer(v1.iterator());
        if (!v2.isEmpty()) queue.offer(v2.iterator());
    }

    public int next() {
        Iterator<Integer> it = queue.poll();
        int res = it.next();
        if (it.hasNext()) queue.offer(it);
        return res;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }



//    private List<Integer> v1, v2;
//    private int i, j; // 指向 v1 和 v2 当前索引
//    private boolean turn; // 交替选择 v1 和 v2
//
//    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
//        this.v1 = v1;
//        this.v2 = v2;
//        this.i = 0;
//        this.j = 0;
//        this.turn = true; // 初始从 v1 开始
//    }
//
//    public int next() {
//        if ((turn && i < v1.size()) || j >= v2.size()) {
//            turn = false;
//            return v1.get(i++);
//        } else {
//            turn = true;
//            return v2.get(j++);
//        }
//    }
//
//    public boolean hasNext() {
//        return i < v1.size() || j < v2.size();
//    }
}
