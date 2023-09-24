package RangeExtraction;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static String rangeExtraction(int[] arr) {
        int curRange = -1;
        int curLeft = Integer.MIN_VALUE;
        StringBuilder ans = new StringBuilder();
        for (int i : arr) {
            if (curLeft + 1 + curRange != i) {
                if (curRange > 1) ans.append("-").append(curLeft + curRange).append(',').append(i);
                else if (curRange == 1) ans.append(',').append(curLeft + 1).append(',').append(i);
                else if (curRange == 0) ans.append(',').append(i);
                else ans.append(i);
                curLeft = i;
                curRange = 0;
            } else curRange++;
        }
        if (curRange > 1) ans.append("-").append(curLeft + curRange);
        else if (curRange == 1) ans.append(',').append(curLeft + 1);
        return ans.toString();
    }


    public static void main(String[] args) {
        System.out.println(Solution.rangeExtraction(new int[]{-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 21, 22, 25}));
        //System.out.println(Solution.rangeExtraction(new int[]{}));
    }
}
