package Codewars.CountSum;

public class CountSum {
    public static void main(String[] args) {

    }

    public static int[] countPositivesSumNegatives(int[] input) {
        int count = 0;
        int sum = 0;
        if (input != null && input.length != 0) {
            for (int n : input) {
                if (n > 0) count++;
                else if (n < 0) sum += n;
            }
        } else return new int[]{};
        return new int[]{count, sum}; //return an array with count of positives and sum of negatives
    }
}
