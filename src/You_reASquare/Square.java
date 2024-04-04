package You_reASquare;

public class Square {
    public static void main(String[] args) {
        System.out.println(Square.isSquare(-1));
        System.out.println(Square.isSquare(0));

    }


    public static boolean isSquare(int n) {
        if (n == 0) return true;
        if (n < 0) return false;
        for (int i = 1; i < Math.sqrt(n) + 1; i++)
            if ((double) n / i == i) return true;
        return false;
    }
}
