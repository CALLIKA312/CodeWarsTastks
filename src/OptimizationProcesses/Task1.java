package OptimizationProcesses;

public class Task1 {
    //6. Реализуйте метод для выполнения простейшего сжатия строк с использованием счетчика повторяющихся символов.
    // Например, строка ааЬсссссааа превращается в а2bс5а3. Если «сжатая» строка не становится короче исходной, то метод возвращает исходную строку.
    // Предполагается, что строка состоит только из букв верхнего и нижнего регистра (a-z)

    //    static String input = "ааЬсссссааа";
    static String input = "аааааbcd";

//    static String input = "аЬсd";

    public static void main(String[] args) {
        System.out.println(task(input));
    }

    public static String task(String s) {
        StringBuilder output = new StringBuilder("");
        if (s.length() < 2) return s;
        char cur = s.charAt(0);
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (cur == ch) count++;
            else {
                if (count == 1) output.append(cur);
                else output.append(cur).append(count);
                count = 1;
            }
            cur = ch;
        }
        if (count == 1) output.append(cur);
        else output.append(cur).append(count);
        if (s.length() < output.length()) {
            return s;
        } else return output.toString();
    }
}
