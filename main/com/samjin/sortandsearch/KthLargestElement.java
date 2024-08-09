package com.samjin.sortandsearch;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // pos + 1 就是第几大数
            int pos = findPosition(nums, left, right);
            if (pos == k - 1) {
                return nums[pos];
            } else if (pos > k - 1) { // 选定的数字小了, 结果在 pos 左边
                right = pos - 1;
            } else {
                left = pos + 1; // 选定的数字大了, 结果在 pos 右边
            }
        }

        return -1;
    }

    private int findPosition(int[] nums, int left, int right) {
        int pivot = nums[left];

        int l = left + 1;
        // 指向第一个大于curr的数字, 所以最后和r进行交换
        int r = right;
        // 使 curr 左边的值都大于它, 右边的值都小于它
        // 要使用 <=
        // 否则[2,1] 1 这种情况会报错
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l, r);
                l++;
                r--;
            }
            // 跳过符合条件的值
            if (nums[l] >= pivot)
                l++;
            if (nums[r] <= pivot)
                r--;
        }

        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
