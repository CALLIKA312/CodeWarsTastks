package LeetCode.WC400.A;

class Solution {
    public static int minimumChairs(String s) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (char c : s.toCharArray()) {
            if (c == 'E') count++;
            else count--;
            if (max < count) max = count;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "ELELEEL";
        System.out.println(minimumChairs(s));
    }
}