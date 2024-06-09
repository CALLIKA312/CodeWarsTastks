package LeetCode.Daily.LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        char[] two = new char[]{'a', 'b', 'c'};
        char[] three = new char[]{'d', 'e', 'f'};
        char[] four = new char[]{'g', 'h', 'i'};
        char[] five = new char[]{'j', 'k', 'l'};
        char[] six = new char[]{'m', 'n', 'o'};
        char[] seven = new char[]{'p', 'q', 'r', 's'};
        char[] eight = new char[]{'t', 'u', 'v'};
        char[] nine = new char[]{'w', 'x', 'y', 'z'};

        List<String> ans = new ArrayList<>();

        char[] digs = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        generatePermutationsHelper(digs, 0, ans, sb);
        return ans;
    }


    private static void generatePermutationsHelper(char[] chars, int index, List<String> result, StringBuilder sb) {
        if (index == chars.length - 1) {
            result.add(sb.toString());
            return;
        }

        for (int i = index; i < chars.length; i++) {
            switch (chars[i]) {                case '2':

            }
            generatePermutationsHelper(chars, index + 1, result, sb);
        }
    }
}