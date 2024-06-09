package LeetCode.Daily.HandofStraights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        int counter = hand.length / groupSize;
        boolean[] used = new boolean[hand.length];
        Arrays.fill(used, false);
        used[0] = true;
        List<Integer> numbersIndex = new ArrayList<>();
        numbersIndex.add(0);
        for (int i = 0; i < counter; i++)
            if (foundStraight(hand, 0, numbersIndex, used, groupSize, hand[0]) != -1)
                return false;
        return true;

        /*for (int i = 0; i < hand.length; i++) {
            int card1 = hand[i];
            if (!used[i]) {
                for (int j = i + 1; j < hand.length; j++) {
                    int card2 = hand[j];
                    if (card1 + 1 == card2 && !used[j]) {
                        for (int k = j + 1; k < hand.length; k++) {
                            int card3 = hand[k];
                            if (card2 + 1 == card3 && !used[k]) {
                                used[i] = true;
                                used[j] = true;
                                used[k] = true;
                                counter--;
                                break;
                            } else if (k == hand.length - 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }*/
    }

    private static int foundStraight(int[] hand, int index, List<Integer> numbersIndex, boolean[] used, int groupSize, int prevValue) {
        if (numbersIndex.size() == groupSize) {
            for (int i = 0; i < numbersIndex.size(); i++)
                used[numbersIndex.get(i)] = true;
            numbersIndex = new ArrayList<>();
            return index + 1;
        }

        for (int i = index; i < hand.length; i++) {
            int curValue = hand[i];
            if (!used[i] && prevValue + 1 == curValue) {
                numbersIndex.add(i);
                index = foundStraight(hand, index + 1, numbersIndex, used, groupSize, curValue);
                if (index < hand.length) {
                    numbersIndex.add(index);
                    used[index] = true;
                    prevValue = hand[index];
                    foundStraight(hand, index, numbersIndex, used, groupSize, prevValue);
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 4, 5, 6};
        int groupSize = 2;
        System.out.println(isNStraightHand(hand, groupSize));
    }
}