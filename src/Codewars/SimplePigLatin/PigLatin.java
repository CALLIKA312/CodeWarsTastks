package Codewars.SimplePigLatin;

public class PigLatin {

    public static String pigIt(String str) {
        char curFirstLetter = ' ';
        StringBuilder builder = new StringBuilder();
        boolean gotFirst = false;
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            if (Character.isLetter(curChar) && !gotFirst) {
                gotFirst = true;
                curFirstLetter = curChar;
                continue;
            } else if (Character.isLetter(curChar) && gotFirst) {
                builder.append(curChar);
                continue;
            } else if (!Character.isLetter(curChar) && gotFirst) {
                gotFirst = false;
                builder.append(curFirstLetter).append("ay");
            }
            builder.append(curChar);
        }
        if (gotFirst) builder.append(curFirstLetter).append("ay");
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(PigLatin.pigIt("Pig latin is cool"));
        System.out.println(PigLatin.pigIt("This. is my! string"));
    }
}
