package OptimizationProcesses.L3;

import java.io.IOException;
import java.util.Scanner;

public class DoubleToBinary {
    public static void main(String[] args) throws IOException {
        double num = 0.72;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите вещественное число с запятой");
        num = in.nextDouble();

        if (num > 1 || num < 0) System.out.println("Ошибка: Введите вещественное число в интервале от 0 до 1.");
        else {
            String s = convertToBinary(num);
            if (s.length() > 32)
                System.out.println("Ошибка: Двоичное представление не умещается в 32 бита.");
            else
                System.out.println("Двоичное представление: " + s);
        }
    }

    private static String convertToBinary(double num) {
        if (num == 0) return "0";
        StringBuilder binary = new StringBuilder("0.");
        while (num > 0) {
            num *= 2;
            if (num >= 1) {
                binary.append("1");
                num -= 1;
            } else binary.append("0");
        }
        return binary.toString();
    }
}
