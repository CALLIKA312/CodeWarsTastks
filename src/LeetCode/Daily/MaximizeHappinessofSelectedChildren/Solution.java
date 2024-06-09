package LeetCode.Daily.MaximizeHappinessofSelectedChildren;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public static long maximumHappinessSum(int[] happiness, int k) {
        long max = 0;
        Integer[] hS = Arrays.stream(happiness).boxed().toList().toArray(new Integer[0]);
        Arrays.sort(hS, Collections.reverseOrder());
        int subtrahend = 0;
        while (subtrahend < k) {
            max += Math.max(hS[subtrahend] - subtrahend, 0);
            subtrahend++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] happiness = {12, 1, 42};
        int k = 3;
        System.out.println(maximumHappinessSum(happiness, k));
    }
}