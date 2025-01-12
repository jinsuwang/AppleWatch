package com.samjin.math;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {

    private List<Integer> prefixProducts;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1); // 初始前缀积为 1
    }

    public void add(int num) {
        if (num == 0) {
            // 如果 num 是 0，清空前缀积并重新开始
            prefixProducts = new ArrayList<>();
            prefixProducts.add(1);
        } else {
            int lastProduct = prefixProducts.get(prefixProducts.size() - 1);
            prefixProducts.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {
        int n = prefixProducts.size();
        if (k >= n) {
            // 如果 k 超过当前前缀积的长度，说明跨度包括 0，直接返回 0
            return 0;
        }
        return prefixProducts.get(n - 1) / prefixProducts.get(n - 1 - k);
    }
}
