package Codewars.Isogram;

import java.util.HashSet;

public class Isogram {
    public static void main(String[] args) {
        System.out.println(isIsogram("Dermatoglyphics"));
        System.out.println(isIsogram("isogram"));
        System.out.println(isIsogram("moose"));
        System.out.println(isIsogram("isIsogram"));
        System.out.println(isIsogram("aba"));
        System.out.println(isIsogram("moOse"));
        System.out.println(isIsogram("thumbscrewjapingly"));
        System.out.println(isIsogram(""));
    }

    public static boolean isIsogram(String str) {
        if (str.isEmpty()) return true;
        str = str.toLowerCase();
        HashSet<Character> strings  = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            boolean ans =  strings.add(str.charAt(i));
            if (!ans) return false;
        }
        return true;
    }

}
