package Codewars.DigPow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DigPow {
    public static void main(String[] args) {
        System.out.println(digPow(89, 1));
        System.out.println(digPow(92, 1));
        System.out.println(digPow(46288, 3));
    }

    public static long digPow(int n, int p) {
        long sum = 0;
        for (int num : intToReverseArr(n)) {
            sum += Math.pow(num, p);
            p++;
        }
        if (sum % n == 0) return sum / n;
        else return -1;
    }

    public static List<Integer> intToReverseArr(int n) {
        List<Integer> arr = new ArrayList<>();
        while (n > 0) {
            arr.add(n % 10);
            n /= 10;
        }
        Collections.reverse(arr);
        return arr;
    }
}
