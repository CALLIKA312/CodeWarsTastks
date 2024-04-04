package ReversedStrings;

public class ReversedStrings {
    public static void main(String[] args) {
        System.out.println(solution("world"));
        System.out.println(solution("word"));
    }

    public static String solution(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = str.length() - 1; i > -1; i--) builder.append(str.charAt(i));
        return builder.toString();
    }
}
