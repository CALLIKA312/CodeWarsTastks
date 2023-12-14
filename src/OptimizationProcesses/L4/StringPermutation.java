package OptimizationProcesses.L4;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public static void main(String[] args) {
        String input = "abcd";
        List<String> permutations = generatePermutations(input);

        System.out.println("Перестановки строки " + input + ":");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    private static List<String> generatePermutations(String input) {
        List<String> result = new ArrayList<>();
        generatePermutationsHelper(input.toCharArray(), 0, result);
        return result;
    }

    private static void generatePermutationsHelper(char[] chars, int index, List<String> result) {
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            generatePermutationsHelper(chars, index + 1, result);
            swap(chars, index, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
