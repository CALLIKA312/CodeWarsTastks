package Codewars.StringToNumber;

public class StringToNumber {
    public static void main(String[] args) {
        System.out.println(stringToNumber("1234"));
        System.out.println(stringToNumber("605"));
        System.out.println(stringToNumber("-7"));

    }

    public static int stringToNumber(String str) {
        return Integer.parseInt(str);
    }
}
