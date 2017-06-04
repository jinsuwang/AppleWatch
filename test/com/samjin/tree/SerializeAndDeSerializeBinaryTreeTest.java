package com.samjin.tree;

import com.samjin.util.TestFactory;
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

    @Before
    public void setUp() throws Exception {
        driver = new SerializeAndDeSerializeBinaryTree();
        root = TestFactory.getTestIntegerBST();
    }

    @Test
    public void serialize() throws Exception {
        System.out.println(driver.serialize(root));
    }

    @Test
    public void serializeRecur(){
        System.out.println(driver.serializeRecur(root));
    }

    @Test
    public void deserialzie() throws Exception {

    }

}