package Codewars.Order;

public class Order {
    public static String order(String words) {
        if (words.isEmpty()) return "";
        String[] arrS = words.split(" ");
        StringBuilder sb = new StringBuilder();
        String[] arrR = new String[arrS.length];
        for (String s : arrS)
            for (Character c : s.toCharArray())
                if (Character.isDigit(c))
                    arrR[Integer.parseInt(String.valueOf(c)) - 1] = s;
        for (String s : arrR) sb.append(s).append(" ");
        return sb.toString().trim();
    }
}
