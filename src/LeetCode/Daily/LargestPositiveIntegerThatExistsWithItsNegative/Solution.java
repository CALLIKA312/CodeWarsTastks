package LeetCode.Daily.LargestPositiveIntegerThatExistsWithItsNegative;

import java.util.Arrays;

class Solution {
    public int findMaxK(int[] nums) {
        int max = -1;
        for (int num : nums)
            if (Arrays.stream(nums).anyMatch(value -> value == -num) && max < num)
                max = num;
        return max;
    }
}
