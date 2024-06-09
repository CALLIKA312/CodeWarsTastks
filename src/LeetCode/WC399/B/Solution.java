package LeetCode.WC399.B;

class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        char curChar = word.charAt(0);
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (curChar == word.charAt(i)) {
                count++;
                if (count == 9) {
                    sb.append(9).append(curChar);
                    count = 0;
                    curChar = word.charAt(i);
                }
            } else {
                if(count != 0) sb.append(count).append(curChar);
                curChar = word.charAt(i);
                count = 1;
            }
        }
        if (count != 0) sb.append(count).append(curChar);
        return sb.toString();
    }
}