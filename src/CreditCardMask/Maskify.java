package CreditCardMask;

public class Maskify {

    public static String maskify(String str) {
        if (str.length() < 4) return str;
        return "#".repeat(str.length() - 4) +
                str.substring(str.length() - 4);
    }

    public static void main(String[] args) {
        System.out.println(Maskify.maskify("4556364607935616"));
        System.out.println(Maskify.maskify(     "64607935616"));
        System.out.println( Maskify.maskify(               "1"));
        System.out.println( Maskify.maskify(                ""));
        System.out.println(Maskify.maskify("Skippy"));
        System.out.println(Maskify.maskify("Nananananananananananananananana Batman!"));

    }
}
