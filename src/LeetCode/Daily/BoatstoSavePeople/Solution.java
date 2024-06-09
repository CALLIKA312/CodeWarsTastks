package LeetCode.Daily.BoatstoSavePeople;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    /*public static int numRescueBoats(int[] people, int limit) {
        int boatCount = 0;
        int curWeight = 0;
        for (int i = 0; i < people.length; i++) {
            curWeight += people[i];
            people[i] = Integer.MAX_VALUE / 2;
            if (curWeight < limit) {
                int jMax = 0;
                int max = 0;
                for (int j = i + 1; j < people.length; j++) {
                    if (curWeight + people[j] < limit) {
                        if (people[j] > max) {
                            max = people[j];
                            jMax = j;
                        }
                    }
                    if (curWeight + people[j] == limit) {
                        jMax = j;
                        break;
                    }
                }
                people[jMax] = Integer.MAX_VALUE / 2;
                boatCount++;
            } else if (curWeight == limit) boatCount++;
            curWeight = 0;
        }
        return boatCount;
    }*/

    public static int numRescueBoats(int[] people, int limit) {
        int boatCount = 0;
        int curWeight = 0;
        Arrays.sort(people);
        for (int i = 0; i < people.length; i++) {
            curWeight += people[i];
            if (curWeight < limit) {
                for (int j = people.length - 1; j > i; j--) {
                    if (people[i] + people[j] <= limit) {
                        people[j] = Integer.MAX_VALUE / 2;
                        boatCount++;
                        curWeight = 0;
                        break;
                    }
                }
                if (curWeight > 0) boatCount++;
            } else if (curWeight == limit) boatCount++;
            curWeight = 0;
        }
        return boatCount;
    }



    /*public static int numRescueBoats(int[] people, int limit) {
        int boatCount = 0;
        int curWeight = 0;
        for (int i = 0; i < people.length; i++) {
            curWeight += people[i];
            if (curWeight < limit) {
                for (int j = limit - curWeight; j < limit; j++) {
                    int finalJ = j;
                    if (IntStream.of(people).anyMatch(value -> value == finalJ)) {
                        people[listIndexOf(people, finalJ)] = Integer.MAX_VALUE / 2;
                        boatCount++;
                    }
                }
            } else if (curWeight == limit) boatCount++;
            curWeight = 0;
        }
        return boatCount;
    }*/

    static int listIndexOf(int[] numbers, int target) {
        List<Integer> list = Arrays.stream(numbers).boxed().toList();
        return list.indexOf(target);
    }

    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        System.out.println(numRescueBoats(people, limit));
    }
}
