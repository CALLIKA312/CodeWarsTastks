package LeetCode.WC399.C;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static long numberOfPairs(int[] nums1, int[] nums2, int k) {
        HashMap<Integer, Integer> goodNumbers1 = new HashMap<>();
        HashMap<Integer, Integer> goodNumbers2 = new HashMap<>();
        System.out.println(nums1.length);
        System.out.println(nums2.length);
        long res = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (goodNumbers1.get(nums1[i]) != null && goodNumbers1.get(nums1[i]) == 0) continue;
            if (goodNumbers1.get(nums1[i]) != null && goodNumbers1.get(nums1[i]) > 0) {
                res += goodNumbers1.get(nums1[i]);
                continue;
            }
            for (int j = 0; j < nums2.length; j++) {
                if (goodNumbers2.getOrDefault(nums2[j], 0) > 0) {
                    int count1 = goodNumbers1.getOrDefault(nums1[i], 0);
                    goodNumbers1.put(nums1[i], count1 + 1);
                    res++;
                    continue;
                }
                if (nums1[i] % (nums2[j] * k) == 0) {
                    int count1 = goodNumbers1.getOrDefault(nums1[i], 0);
                    goodNumbers1.put(nums1[i], count1 + 1);
                    goodNumbers2.put(nums2[j], 1);
                    res++;
                }
            }
            if (!(goodNumbers1.get(nums1[i]) != null && goodNumbers1.get(nums1[i]) > 0)) goodNumbers1.put(nums1[i], 0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 1, 3, 4};
        int[] nums2 = new int[]{1, 1, 1, 3, 4};
        int k = 1;
        System.out.println(numberOfPairs(nums1, nums2, k));
    }
}
