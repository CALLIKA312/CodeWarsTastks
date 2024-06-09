package Codewars.JadenCase;

public class JadenCase {
    public static void main(String[] args) {

    }

    public String toJadenCase(String phrase) {
        if (phrase == null) return null;
        if (phrase.length() == 0) return null;
        String[] words = phrase.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            String c = String.valueOf(s.charAt(0)).toUpperCase();
            sb.append(c).append(s.substring(1)).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}
