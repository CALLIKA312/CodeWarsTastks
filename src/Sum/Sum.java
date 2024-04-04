package Sum;

public class Sum {
    public static void main(String[] args) {
        System.out.println(GetSum(-1, 0));
        System.out.println(GetSum(-1, 2));
    }

    public static int GetSum(int a, int b) {
        if (a == b) return a;
        if (a > b) {
            int c = a;
            a = b;
            b = c;
        }
        int sum = 0;
        for (int i = a; i < b + 1; i++) sum += i;
        return sum;
    }


}
