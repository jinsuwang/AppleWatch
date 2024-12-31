package com.samjin.string;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        int left = 0, right = s.length() - 1;

        // Step 2: Loop until the pointers meet
        while (left < right) {
            // Step 3: Move left pointer to the next alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Step 4: Move right pointer to the previous alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Step 5: Compare the characters (ignoring case)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // Step 6: Move both pointers towards the center
            left++;
            right--;
        }

        // Step 7: If we finish the loop without finding unequal characters, return true
        return true;

    }
}
