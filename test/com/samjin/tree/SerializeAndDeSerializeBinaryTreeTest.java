package com.samjin.tree;

import com.samjin.util.TestFactory;
import com.samjin.util.TraversalHelper;
import com.samjin.util.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sjjin on 6/1/17.
 */
public class SerializeAndDeSerializeBinaryTreeTest {

    SerializeAndDeSerializeBinaryTree driver;
    TreeNode root;


    TreeNode l1 = new TreeNode(-1);
    TreeNode l2 = new TreeNode(0);
    TreeNode l3 = new TreeNode(1);

    @Before
    public void setUp() throws Exception {
        driver = new SerializeAndDeSerializeBinaryTree();

        l1.left = l2;
        l1.right = l3;

    }

    @Test
    public void serializeIter(){
        System.out.println(driver.serializeIter(l1));
    }

    @Test
    public void serialize(){
        System.out.println(driver.serialize(l1));
    }

    @Test
    public void deserialize() throws Exception {
        String str = driver.serialize(l1);
        TreeNode newNode = driver.deserialize(str);
        System.out.println( new TraversalHelper().inorderTraversalIter(newNode) );
    }
}