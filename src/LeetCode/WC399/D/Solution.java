package LeetCode.WC399.D;

import java.util.Arrays;

class Solution {
    public static int maximumSumSubsequence(int[] nums, int[][] queries) {
        int ans = 0;
        for (int[] arr : queries) {
            nums[arr[0]] = arr[1];
            int maxSum = 0;
            for (int num : nums) {
                if (num <= 0) continue;
                maxSum += num;
            }
            ans += maxSum;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 3, 3, 1, -2};
        int[][] queries = {{4, 0}, {1, 0}};
        System.out.println(maximumSumSubsequence(nums, queries));

    }
}
