package com.samjin.array;


import org.junit.Test;

public class RemoveElementTest {

        RemoveElement re = new RemoveElement();

        @Test
        public void removeElement() {
            int[] input = new int[]{3, 2, 2, 3};
            int target = 3;

            assert(2 == re.removeElement(input, target));
        }

}