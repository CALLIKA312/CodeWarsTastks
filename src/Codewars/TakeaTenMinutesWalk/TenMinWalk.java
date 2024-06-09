package Codewars.TakeaTenMinutesWalk;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        int countN = 0;
        int countS = 0;
        int countW = 0;
        int countE = 0;
        for (char c : walk)
            switch (c) {
                case 'n' -> countN++;
                case 's' -> countS++;
                case 'w' -> countW++;
                case 'e' -> countE++;
            }
        int sum = countN + countS + countW + countE;
        return countN == countS && countW == countE && sum == 10;
    }
}
