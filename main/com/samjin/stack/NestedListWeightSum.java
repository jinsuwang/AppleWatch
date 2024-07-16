//package com.samjin.stack;
//
//public class NestedListWeightSum {
//
////    public int depthSum(List<NestedInteger> nestedList) {
////        int res = 0;
//
////        Queue<NestedInteger> queue = new LinkedList<>();
////
////        for(NestedInteger n : nestedList) {
////            queue.add(n);
////        }
////
////        int level = 1;
////        while(!queue.isEmpty()) {
////            int size = queue.size();
////
////            for (int i = 0; i < size; i++) {
////                NestedInteger n = queue.poll();
////                if (n.isInteger()) {
////                    res += n.getInteger() * level;
////                } else {
////                    List<NestedInteger> ll = n.getList();
////                    queue.addAll(ll);
////                }
////            }
////
////            level += 1;
////        }
//
////        return res;
//    }
//}
