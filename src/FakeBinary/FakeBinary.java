package FakeBinary;

public class FakeBinary {
    public static void main(String[] args) {
        System.out.println(fakeBin("45385593107843568"));
    }

    public static String fakeBin(String numberString) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberString.length(); i++)
            if (Integer.parseInt(String.valueOf(numberString.charAt(i))) < 5) sb.append(0);
            else sb.append(1);
        return sb.toString();
    }
}
