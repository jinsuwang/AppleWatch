package com.samjin.array;

public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        // 找到在环上的某一点相遇
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        // 找到进入环的点
        fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[fast];
            if (slow == fast) {
                break;
            }
        }

        return slow;
    }
}
