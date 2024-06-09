package Codewars.diff;

import java.util.ArrayList;
import java.util.Arrays;

public class Kata {

    public static int[] arrayDiff(int[] a, int[] b) {
        if (a.length < 1) return a;
        ArrayList<Integer> list = new ArrayList<>();
        boolean foundInB = false;
        for (int numA : a) {
            foundInB = false;
            for (int numB : b) {
                if (numA == numB) {
                    foundInB = true;
                    break;
                }
            }
            if (!foundInB) list.add(numA);
        }

        if (!list.isEmpty()) {
            int[] c = new int[list.size()];
            for (int i = 0; i < c.length; i++) c[i] = list.get(i);
            a = c;
        } else return new int[0];
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                Kata.arrayDiff(new int[]{1, 2, 1, 2}, new int[]{1, 2})
        ));
        System.out.println(Arrays.toString(
                Kata.arrayDiff(new int[]{1, 2, 2, 3, 4}, new int[]{1,4})
        ));
        System.out.println(Arrays.toString(
                Kata.arrayDiff(new int[]{}, new int[]{1, 2})
        ));


    }

}