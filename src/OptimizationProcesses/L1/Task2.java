package OptimizationProcesses.L1;

import java.util.*;

public class Task2 {


//6. Реализуйте функцию, проверяющую, является ли связный список палиндромом

//    public static LinkedList<String> list = new LinkedList<>(Arrays.asList("a", "b", "c", "b", "a"));

//    public static LinkedList<String> list = new LinkedList<>(Arrays.asList("a", "c", "b", "b", "a"));

//    public static LinkedList<String> list = new LinkedList<>(Arrays.asList("a", "b", "b", "a"));

    public static LinkedList<String> list = new LinkedList<>(Arrays.asList("a"));


    public static void main(String[] args) {
//        System.out.println(task1(list));
//        System.out.println(task2(list));
        System.out.println(task3(list));

    }

    public static boolean task1(LinkedList<String> list) {
        int half;
        if (list.size() % 2 != 0) half = list.size() / 2;
        else half = list.size() / 2 + 1;
        for (int i = 0; i < half; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) return false;
        }
        return true;
    }

    public static boolean task2(LinkedList<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if (map.containsKey(s)) map.replace(s, map.get(s) + 1);
            else map.put(s, 1);
        }
        ArrayList<Integer> values = new ArrayList<>(map.values());
        int oddCount = 0;
        for (int value : values) if (value % 2 == 1) oddCount++;
        return oddCount <= 1;
    }

    public static boolean task3(LinkedList<String> list) {
        int half;
        half = list.size() / 2;
        for (int i = 0; i < half; i++) {
            if (!list.pollFirst().equals(list.pollLast())) return false;
        }
        return true;
    }
}
