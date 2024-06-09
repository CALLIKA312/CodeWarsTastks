package Codewars.RGBToHexConversion;

public class RgbToHex {

    public static String rgb(int r, int g, int b) {
        return String.format("%01$2s%02$2s%03$2s", Integer.toHexString(checkRange(r)), Integer.toHexString(checkRange(g)), Integer.toHexString(checkRange(b))).replace(' ', '0').toUpperCase();
    }

    public static int checkRange(int num) {
        if (num > 255) num = 255;
        if (num < 0) num = 0;
        return num;
    }

    public static void main(String[] args) {
        System.out.println(RgbToHex.rgb(0, 0, 0));
        System.out.println(RgbToHex.rgb(1, 2, 3));
        System.out.println(RgbToHex.rgb(255, 255, 255));
        System.out.println(RgbToHex.rgb(254, 253, 252));
        System.out.println(RgbToHex.rgb(-20, 275, 125));
    }
}

