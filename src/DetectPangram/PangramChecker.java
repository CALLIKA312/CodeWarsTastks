package DetectPangram;

import java.util.HashMap;
import java.util.Map;

public class PangramChecker {
    public static boolean check(String sentence) {
        for (char let = 'a'; let < 'z'; let++) if (!sentence.toLowerCase().contains("" + let)) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(check("The quick brown fox jumps over the lazy dog."));
        System.out.println(check("You shall not pass!"));
    }
}