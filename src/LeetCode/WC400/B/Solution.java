package LeetCode.WC400.B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /*public static int countDays(int days, int[][] meetings) {
        int[] sched = new int[days];
        Arrays.fill(sched, 1);
        for (int[] d : meetings)
            Arrays.fill(sched, d[0] - 1, d[1], 0);
        int ans = 0;
        for (int d : sched) if (d == 1) ans++;
        return ans;
    }
*/
    public static int countDays(int days, int[][] meetings) {
        List<int[]> meetingsMerged = new ArrayList<>();
        for (int i = 0; i < meetings.length; i++) {
            int leftI = meetings[i][0];
            int rightI = meetings[i][1];
            for (int j = i; j < meetings.length; j++) {
                int leftJ = meetings[j][0];
                int rightJ = meetings[j][1];
                if (leftI < leftJ && rightI < rightJ) meetingsMerged.add(new int[]{leftI, rightJ});
                else if (leftI > leftJ && rightI > rightJ) meetingsMerged.add(new int[]{leftJ, rightI});
                else if (leftI < leftJ && rightI > rightJ) meetingsMerged.add(new int[]{leftI, rightI});
                else if (leftI > leftJ && rightI < rightJ) meetingsMerged.add(new int[]{leftJ, rightJ});
            }

        }


        int[] sched = new int[days];
        Arrays.fill(sched, 1);
        for (int[] d : meetings)
            Arrays.fill(sched, d[0] - 1, d[1], 0);
        int ans = 0;
        for (int d : sched) if (d == 1) ans++;
        return ans;
    }


    public static void main(String[] args) {
        int days = 10;
        int[][] meetings = {{5, 7}, {1, 3}, {9, 10}};
        System.out.println(countDays(days, meetings));

    }

}