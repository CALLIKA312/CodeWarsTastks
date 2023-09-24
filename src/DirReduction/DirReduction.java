package DirReduction;

import java.util.Arrays;
import java.util.Stack;

public class DirReduction {

    public static String[] dirReduc(String[] arr) {
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            s = s.toUpperCase();
            if (stack.empty()) {
                stack.push(s);
                continue;
            }
            switch (s) {
                case "NORTH":
                    if (!stack.peek().equalsIgnoreCase("SOUTH")) stack.push(s);
                    else stack.pop();
                    break;
                case "SOUTH":
                    if (!stack.peek().equalsIgnoreCase("NORTH")) stack.push(s);
                    else stack.pop();
                    break;
                case "EAST":
                    if (!stack.peek().equalsIgnoreCase("WEST")) stack.push(s);
                    else stack.pop();
                    break;
                case "WEST":
                    if (!stack.peek().equalsIgnoreCase("EAST")) stack.push(s);
                    else stack.pop();
                    break;
            }
        }
        return stack.toArray(new String[0]);
    }


    public static void main(String[] args) {
        String[] str = {"NORTH", "EAST", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};
        System.out.println(Arrays.toString(dirReduc(str)));
    }
}

