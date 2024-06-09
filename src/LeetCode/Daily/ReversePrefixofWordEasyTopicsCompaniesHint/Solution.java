package LeetCode.Daily.ReversePrefixofWordEasyTopicsCompaniesHint;

class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (char c : word.toCharArray()) {
            sb.append(c);
            i++;
            if (c == ch){
                sb.reverse();
                break;
            }
        }
        sb.append(word.substring(i));
        return sb.toString();
    }
}