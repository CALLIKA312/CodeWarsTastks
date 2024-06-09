package LeetCode.Daily.FindCommonCharacters;

import java.util.*;

class Solution {
    public static List<String> commonChars(String[] words) {
        HashMap<Character, Integer>[] wordsLetters = new HashMap[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] chars = word.toCharArray();
            HashMap<Character, Integer> mappedChar = new HashMap<>();
            for (Character c : chars) {
                int count = mappedChar.getOrDefault(c, 0);
                mappedChar.put(c, count + 1);
            }
            wordsLetters[i] = mappedChar;
        }
        HashMap<Character, Integer> res = wordsLetters[0];
        for (int i = 1; i < wordsLetters.length; i++)
            res = compareMaps(res, wordsLetters[i]);

        List<String> ans = new ArrayList<>();
        for (Character c : res.keySet()) {
            for (int i = 0; i < res.get(c); i++) {
                ans.add(c.toString());
            }
        }
        return ans;
    }

    public static HashMap<Character, Integer> compareMaps(HashMap<Character, Integer> wordLetters1, HashMap<Character, Integer> wordLetters2) {
        Set<Character> mainSet = wordLetters1.keySet();
        HashMap<Character, Integer> res = new HashMap<>();
        for (Character c : mainSet)
            if (wordLetters2.containsKey(c)) {
                if (wordLetters1.get(c) < wordLetters2.get(c))
                    res.put(c, wordLetters1.get(c));
                else
                    res.put(c, wordLetters2.get(c));
            }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"cool", "lock", "cook"};
        List<String> ans = List.of(new String[]{"c", "o"});
        List<String> res = commonChars(words);
        System.out.println(res);
        System.out.println(
                compareAns(
                        res, ans
                )
        );
    }

    private static String compareAns(List<String> list1, List<String> list2) {
        if (list1.equals(list2)) return "TRUE";
        else return "FALSE \n EXPECTED: " + list2;
    }
}
