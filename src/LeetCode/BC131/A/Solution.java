package LeetCode.BC131.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static int duplicateNumbersXOR(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap();
        for (int num : nums)
            count.put(num, count.getOrDefault(count, 0) + 1);
        List<Integer> duples = new ArrayList<>();
        for (int c : count.keySet())
            if (count.get(c) > 1) duples.add(c);
        int res = 0;
        if (duples.size() > 0) res = duples.get(0);
        for (int i = 1; i < duples.size(); i++) {
            int dup = duples.get(i);
            res ^= dup;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3};
        System.out.println(duplicateNumbersXOR(nums));
        nums = new int[]{1, 2, 3};
        System.out.println(duplicateNumbersXOR(nums));
        nums = new int[]{1, 2, 2, 1};
        System.out.println(duplicateNumbersXOR(nums));
    }
}
