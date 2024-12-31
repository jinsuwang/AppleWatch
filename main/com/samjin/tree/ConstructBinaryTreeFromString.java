package com.samjin.tree;

public class ConstructBinaryTreeFromString {

    public TreeNode str2tree(String s) {

        if (s.length() == 0) return null;


        int rootEnd = s.indexOf("(");

        if(rootEnd == -1){
            return new TreeNode(Integer.parseInt(s));
        }

        int rootVal = Integer.parseInt(s.substring(0, rootEnd));

        TreeNode curr = new TreeNode(rootVal);

        int start = rootEnd;
        int leftParenCount = 0;

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                leftParenCount++;
            }else if (c == ')') {
                leftParenCount--;
            }

            if (leftParenCount == 0) {
                if(start == rootEnd) {
                    curr.left = str2tree(s.substring(start + 1, i));
                    start = i + 1;
                } else {
                    curr.right = str2tree(s.substring(start + 1, i));
                }
            }
        }
        return curr;

    }
}
