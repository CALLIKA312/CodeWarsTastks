package Banjo;

public class Banjo {
    public static String areYouPlayingBanjo(String name) {
        String s = String.valueOf(name.charAt(0));
        if (s.equals("R") || s.equals("r")) return name + " plays banjo";
        else return name + " does not play banjo";
    }
}
