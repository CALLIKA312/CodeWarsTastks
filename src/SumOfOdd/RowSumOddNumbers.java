package SumOfOdd;

class RowSumOddNumbers {
    public static int rowSumOddNumbers(int n) {
        int sum = 0;
        int firstNum = 1;
        for (int i = 1; i < n; i++) firstNum += 2 * i;
        for (int i = 0; i < n; i++) sum += firstNum + 2 * i;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(rowSumOddNumbers(1));
        System.out.println(rowSumOddNumbers(2));
        System.out.println(rowSumOddNumbers(3));
        System.out.println(rowSumOddNumbers(4));
    }
}