package com.samjin.heap;
import java.util.Arrays;
import java.util.Comparator;

public class CustomComparator {


    public static void main(String[] args) {


        String[] test = new String[]{"5","3","4","1","2"};

        Arrays.sort(test, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // return negative if obj1 < obj2, zero if obj1 == obj2, positive if obj1 > obj2
                return a.compareTo(b);
            }
        });

        System.out.println(Arrays.toString(test));
    }
}
