package com.samjin.dfs;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by sjjin on 4/8/18.
 */
public class PermutationTest {

    Permutation ins = new Permutation();

    @Test
    public void permuteUnique() throws Exception {
        int[] input1 = new int[]{1,1,2};
        List<List<Integer>> res = ins.permuteUnique(input1);

        for(List<Integer> s : res){
            System.out.println(s);
        }
    }

}