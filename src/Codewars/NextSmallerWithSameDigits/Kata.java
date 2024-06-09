package Codewars.NextSmallerWithSameDigits;

import java.util.HashMap;
import java.util.Map;

public class Kata {
    public static long nextSmaller(long n) {
        Map<Integer, Integer> map = new HashMap<>();
        long input = n;
        while (n != 0) {
            int digit = (int) (n % 10);
            if (map.containsKey(digit)) map.replace(digit, map.get(digit) + 1);
            else map.put(digit, 1);
            n /= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            if (map.containsKey(i)) {
                sb.append(i);
                map.replace(i, map.get(i) - 1);
                if (map.get(i) == 0) map.remove(i);
                break;
            }
        }
        if (sb.isEmpty()) return -1;


        for (int i = 0; i < 10; i++) {
            while (map.containsKey(i)) {
                int value = map.get(i);
                sb.append(i);
                value--;
                map.replace(i, value);
                if (value == 0) map.remove(i);
            }
        }
        long num = Long.parseLong(sb.toString());
        return num < input ? num : -1;
    }

    public static void main(String[] args) {
        System.out.println(Kata.nextSmaller(21));
        System.out.println(Kata.nextSmaller(907));
        System.out.println(Kata.nextSmaller(531));
        System.out.println(Kata.nextSmaller(1027));
        System.out.println(Kata.nextSmaller(441));
        System.out.println(Kata.nextSmaller(123456798));
    }
}
