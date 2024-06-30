package com.samjin.tree;

import com.samjin.util.TestFactory;
import org.junit.Test;

public class BinaryTreeRightSideViewTest {

    BinaryTreeRightSideView ins = new BinaryTreeRightSideView();

    @Test
    public void rightSideView() {
        TreeNode node = TestFactory.getTestIntegerBST();
        System.out.println(ins.rightSideView(node));
    }
}