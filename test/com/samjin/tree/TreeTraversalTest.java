package com.samjin.tree;

import com.samjin.util.TestFactory;
import com.samjin.util.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sjjin on 9/10/17.
 */
public class TreeTraversalTest {

    TreeNode root;
    TreeTraversal tt;

    @Before
    public void setUp() throws Exception {
        root = TestFactory.getTestIntegerBST();
        tt = new TreeTraversal();
    }

    @Test
    public void inorderTraveralRecur() throws Exception {
        String res1 = tt.inorderTraveralRecur(root);
        System.out.println(res1);
    }

    @Test
    public void inorderTraversalIter() throws Exception {
        String res1 = tt.inorderTraversalIter(root);
        System.out.println(res1);
    }

    @Test
    public void preorderTraveralRecur() throws Exception {
    }

    @Test
    public void preorderTraversalIter() throws Exception {
        System.out.println(tt.preorderTraversalIter(root));
    }

    @Test
    public void postorderTraversalRecur() throws Exception {
    }

    @Test
    public void postorderTraversalIter() throws Exception {
    }

}