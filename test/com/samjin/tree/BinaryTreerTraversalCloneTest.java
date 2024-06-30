package com.samjin.tree;

import com.samjin.util.TestFactory;
import com.samjin.tree.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreerTraversalCloneTest {

    @Test
    public void preorderTraversal() {
        TreeNode root = TestFactory.getTestIntegerBST();

        BinaryTreerTraversalClone obj = new BinaryTreerTraversalClone();

        List<Integer> res = obj.inorderTraversalIter(root);

        System.out.println(res);
    }
}