package Codewars.PersistentBugger;

class Persist {
    public static int persistence(long num) {
        if (num < 10) {
            return 0;
        } else {
            long product = 1;
            while (num > 0) {
                product *= num % 10;
                num /= 10;
            }
            return 1 + persistence(product);
        }
    }
}