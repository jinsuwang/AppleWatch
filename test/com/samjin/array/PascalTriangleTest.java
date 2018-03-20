package com.samjin.array;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PascalTriangleTest {

    PascalTriangle ins = new PascalTriangle();

    @Test
    public void test(){
        List<List<Integer>> res = ins.generate(5);
        for(List<Integer> e : res){
            System.out.println(e);
        }

    }

    @Test
    public void testGetRow(){
        System.out.println(ins.getRow(3));
    }

}