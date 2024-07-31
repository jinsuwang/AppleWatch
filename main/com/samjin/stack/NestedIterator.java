package com.samjin.stack;
import java.util.*;

 // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation

public class NestedIterator implements Iterator<Integer> {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }


    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for(int i = nestedList.size() - 1; i >= 0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        // 注意是while，因为有可能nested中包含了nested，需要把所有的nested解开为integer
        while(!stack.isEmpty()){
            NestedInteger curr = stack.peek();
            if(curr.isInteger()){
                return true;
            } else {
                stack.pop();
                for(int i = curr.getList().size() - 1; i >= 0; i--){
                    NestedInteger temp = curr.getList().get(i);
                    stack.push(temp);
                }
            }
        }

        return false;
    }
}
