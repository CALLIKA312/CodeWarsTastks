package Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Sum4d6 {

    public static void main(String[] args) {
        //rollDice();
        //buyPoints();
        System.out.println(generateStatByDice());
    }

    private static void buyPoints() {
        int cash = 27;
        ArrayList<Integer> statList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            statList.add(generateStatByCash(cash));
        }
        System.out.println(statList);
    }

    private static int generateStatByCash(int cash) {
        Random random = new Random();
        int statV = random.nextInt(8, 15);
        int minus = switch (statV) {
            case 8 -> 0;
            case 9 -> 1;
            case 10 -> 2;
            case 11 -> 3;
            case 12 -> 4;
            case 13 -> 5;
            case 14 -> 7;
            case 15 -> 9;
            default -> 0;
        };
        if (cash - minus >= 0) cash = -minus;
        else generateStatByCash(cash);
        return statV;
    }

    private static ArrayList<Integer> generateStatByDice() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(generateStat());
        }
        return list;
    }

    private static int generateStat() {
        Random random = new Random();
        int d1 = random.nextInt(6) + 1;
        int d2 = random.nextInt(6) + 1;
        int d3 = random.nextInt(6) + 1;
        int d4 = random.nextInt(6) + 1;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);
        int n = 0;
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < list.size(); j++) {
            if (min > list.get(j)) {
                min = list.get(j);
                n = j + 1;
            }
        }
        int sum = 0;
        switch (n) {
            case 1 -> sum += d2 + d3 + d4;
            case 2 -> sum += d1 + d3 + d4;
            case 3 -> sum += d2 + d1 + d4;
            case 4 -> sum += d2 + d3 + d1;
        }
        return sum;
    }

    private static void rollDice() {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            int sum = generateStat();
            if (map.containsKey(sum)) map.put(sum, map.get(sum) + 1);
            else map.put(sum, 1);

        }
        System.out.println(map);
        ArrayList<Double> list = new ArrayList<>();
        double sumL9 = 0;
        double sumH15 = 0;
        for (int i = 3; i < 19; i++) {
            double d = map.get(i);
            d /= 1000;
            list.add(d);
            if (i < 9) sumL9 += d;
            if (i > 15) sumH15 += d;
        }
        System.out.println(list);
        System.out.println("Меньше 9 " + sumL9);
        System.out.println("Больше 15 " + sumH15);
    }
}
