package Snail;

import java.util.Arrays;

public class Snail {

    static int[][] arr = new int[0][0];
    static int n = 0;
    static int curRow = 0;
    static int curCol = 0;
    static int curCir = 0;
    static int curResPos = 0;
    static int[] result = new int[0];

    public static int[] snail(int[][] array) {
        n = array.length;
        if (array[0].length == 0) return new int[]{};
        if (n == 1) return new int[]{array[0][0]};
        arr = array;
        result = new int[n * n];
        if (curResPos + 1 != n * n) moveRight();
        arr = new int[0][0];
        n = 0;
        curRow = 0;
        curCol = 0;
        curCir = 0;
        curResPos = 0;
        int[] ans = result;
        result = new int[0];
        return ans;
    }

    private static void moveRight() {
        for (; curCol < n - curCir; curCol++) {
            result[curResPos] = arr[curRow][curCol];
            curResPos++;
        }
        curCol--;
        curRow++;
        if (curResPos + 1 != n * n) moveDown();
        else {
            result[curResPos] = arr[curRow][curCol];
            curResPos++;
        }
    }

    private static void moveDown() {
        for (; curRow < n - curCir; curRow++) {
            result[curResPos] = arr[curRow][curCol];
            curResPos++;
        }
        curCol--;
        curRow--;
        if (curResPos + 1 != n * n) moveLeft();
        else {
            result[curResPos] = arr[curRow][curCol];
            curResPos++;
        }
    }

    private static void moveLeft() {
        for (; curCol > curCir - 1; curCol--) {
            result[curResPos] = arr[curRow][curCol];
            curResPos++;
        }
        curRow--;
        curCol++;
        curCir++;
        if (curResPos + 1 != n * n) moveUp();
        else {
            result[curResPos] = arr[curRow][curCol];
            curResPos++;
        }
    }

    private static void moveUp() {
        for (; curRow > curCir - 1; curRow--) {
            result[curResPos] = arr[curRow][curCol];
            curResPos++;
        }
        curCol++;
        curRow++;
        if (curResPos + 1 != n * n) moveRight();
        else {
            result[curResPos] = arr[curRow][curCol];
            curResPos++;
        }
    }


    public static void main(String[] args) {
        int a = 6;
        int[][] array = new int[a][a];
        int num = 1;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                array[i][j] = num;
                num++;
            }
        }
//        array = new int[][]{{1, 2, 3, 9},
//                {4, 5, 6, 4},
//                {7, 8, 9, 1},
//                {1, 2, 3, 4}};
        array = new int[][]{{872}};

        System.out.println(Arrays.toString(snail(array)));
    }
}