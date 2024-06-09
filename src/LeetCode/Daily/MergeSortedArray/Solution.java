package LeetCode.Daily.MergeSortedArray;

import java.util.Arrays;

public class Solution {
//    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
//        if (m == 0 && n == 0) return new int[0];
//
//        int lastNum1Value = Integer.MIN_VALUE;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m + n; j++) {
//                if (lastNum1Value < nums1[j] && nums1[j] < nums2[i]) {
//                    continue;
//                }
//                if (nums2[i] < nums1[j]) {
//                    int a = nums1[j];
//                    nums1[j] = nums2[i];
//                    nums2[i] = a;
//                    i--;
//                    if (lastNum1Value < nums1[j]) lastNum1Value = nums1[j];
//                    break;
//                }
//
//                if (nums1[j] == 0) {
//                    nums1[j] = nums2[i];
//                    if (lastNum1Value < nums1[j]) lastNum1Value = nums1[j];
//                }
//            }
//        }
//        return nums1;
//    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
        int m = 6;
        int[] nums2 = {1, 2, 2};
        int n = 3;
        int[] ans = {-1, 0, 0, 1, 2, 2, 3, 3, 3};


        int[] res;
        res = merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(res));
        System.out.println(compare(res, ans));
    }


    private static String compare(int[] arr1, int[] arr2) {
        if (Arrays.equals(arr1, arr2)) return "TRUE";
        else return "FALSE \n EXPECTED: " + Arrays.toString(arr2);
    }
}
