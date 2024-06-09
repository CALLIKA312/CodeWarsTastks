package LeetCode.WC400.C;

import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static String clearStars(String s) {
        List<Character> chars = new java.util.ArrayList<>(s
                .chars()
                .mapToObj(e -> (char) e)
                .toList());
        int leftSmallestPos = -1;
        int leftSmallest = 100;
        for (int i = 0; i < chars.size(); i++) {
            char curChar = chars.get(i);
            if (curChar == '*') {
                if (leftSmallestPos >= 0) {
                    chars.remove(i);
                    chars.remove(leftSmallestPos);
                    leftSmallestPos = -1;
                    leftSmallest = 100;
                    i = -1;
                    continue;
                }
            }
            if (leftSmallest >= curChar - 'a') {
                leftSmallest = curChar - 'a';
                leftSmallestPos = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "d*d*";
        System.out.println(clearStars(s));

    }
}