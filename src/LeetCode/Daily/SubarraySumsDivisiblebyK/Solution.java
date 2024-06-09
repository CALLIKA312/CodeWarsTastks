package LeetCode.Daily.SubarraySumsDivisiblebyK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public static int subarraysDivByK(int[] nums, int k) {
        boolean empty = true;
        for (int num : nums) {
            if (num != 0) {
                empty = false;
                break;
            }
        }
        if (empty) return (nums.length * nums.length) / 2 + nums.length / 2;

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] tmpArr = new int[nums.length - i];
            tmpArr[0] = nums[i];
            if (checkSumDivByK(tmpArr, k)) res++;
            for (int j = i + 1; j < nums.length; j++) {
                tmpArr[j - i] = nums[j];
                if (checkSumDivByK(tmpArr, k)) res++;
            }
        }
        return res;
    }


    public static boolean checkSumDivByK(int[] tmpArr, int k) {
        int sum = 0;
        for (int a : tmpArr) sum += a;
        return sum % k == 0;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));
    }

}