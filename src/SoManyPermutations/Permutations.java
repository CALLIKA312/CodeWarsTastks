package SoManyPermutations;

import java.util.*;

class Permutations {

    public static List<String> singlePermutations(String input) {
        List<String> result = new ArrayList<>();
        permute(input.toCharArray(), 0, result);
        Set<String> uniquePermutations = new HashSet<>(result); // Remove duplicates
        return new ArrayList<>(uniquePermutations);
    }

    private static void permute(char[] arr, int index, List<String> result) {
        if (index == arr.length - 1) {
            result.add(new String(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permute(arr, index + 1, result);
            swap(arr, index, i); // Backtrack
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Permutations.singlePermutations("a"));
        System.out.println(Permutations.singlePermutations("ab"));
        System.out.println(Permutations.singlePermutations("abc"));
        System.out.println(Permutations.singlePermutations("aabb"));
        System.out.println(Permutations.singlePermutations("abaac"));
    }
}