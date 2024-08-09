package com.samjin.stackandqueue;

import java.util.ArrayList;
import java.util.List;

public class ProcessQueriesOnCard {


    public static List<Integer> processQueriesOnCart(int[] items, int[] query) {
        // Initialize the cart with initial items
        List<Integer> cart = new ArrayList<>();
        for (int item : items) {
            cart.add(item);
        }

        // Process each query
        for (int q : query) {
            if (q > 0) {
                // Add the item to the end of the cart
                cart.add(q);
            } else {
                // Remove the first occurrence of the absolute value of q
                cart.remove((Integer) (-q)); // Cast to Integer to remove by value, not by index
            }
        }

        return cart;
    }
}
