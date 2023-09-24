package Stringincrementer;

public class Kata {
//    public static String incrementString(String str) {
//        StringBuilder sb = new StringBuilder(str);
//        sb.reverse();
//        StringBuilder num = new StringBuilder();
//        String reversed = sb.toString();
//        for (int i = 0; i < reversed.length(); i++) {
//            if (Character.isDigit(reversed.charAt(i))) num.append(reversed.charAt(i));
//            else break;
//        }
//        if (num.isEmpty()) return str + 1;
//        str = str.substring(0, str.length() - num.length());
//        num.reverse();
//        long newNum = Long.parseLong(num.toString()) + 1;
//        long newNumDigitsCount = countDig(newNum);
//        if (newNumDigitsCount < num.length()) for (int i = 0; i < num.length() - newNumDigitsCount; i++) str += '0';
//        str += newNum;
//        return str;
//    }

    public static String incrementString(String str) {
        String reversed = new StringBuilder(str).reverse().toString();

        boolean overload = reversed.length() > 1 && reversed.charAt(0) == '9';

        StringBuilder num = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            char curChar = reversed.charAt(i);

            if (Character.isDigit(curChar)) {
                if (overload) {
                    if (curChar == '9') curChar = '0';
                    else {
                        int tmp = (Integer.parseInt(String.valueOf(curChar)) + 1);
                        curChar = String.valueOf(tmp).charAt(0);
                        overload = false;
                    }
                } else if (i == 0) {
                    int tmp = (Integer.parseInt(String.valueOf(curChar)) + 1);
                    curChar = String.valueOf(tmp).charAt(0);
                }
                num.append(curChar);
            } else break;
        }
        if (num.isEmpty()) return str + 1;
        str = str.substring(0, str.length() - num.length());
        if (overload) num.append(1);
        num.reverse();
        str += num;
        return str;
    }

    public static long countDig(long n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            count = count + 1;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(incrementString("foobar000"));
        System.out.println(incrementString("foobar001"));
        System.out.println(incrementString("foo"));
        System.out.println(incrementString("foobar99"));
        System.out.println(incrementString("foobar099"));
        System.out.println(incrementString(""));
    }
}