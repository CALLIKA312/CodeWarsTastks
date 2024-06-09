package Codewars.CountIPAddresses;

public class CountIPAddresses {
    public static long ipsBetween(String start, String end) {
        long ans = 0;
        String[] splitStart = start.split("\\.");
        String[] splitEnd = end.split("\\.");
        ans += Long.parseLong(splitStart[0]) - Long.parseLong(splitEnd[0]) << 24L;
        ans += Long.parseLong(splitStart[1]) - Long.parseLong(splitEnd[1]) << 16L;
        ans += Long.parseLong(splitStart[2]) - Long.parseLong(splitEnd[2]) << 8L;
        ans += Long.parseLong(splitStart[3]) - Long.parseLong(splitEnd[3]);
        return Math.abs(ans);
    }

    public static void main(String[] args) {
        System.out.println(CountIPAddresses.ipsBetween("10.0.0.0", "10.0.0.50"));
        System.out.println(CountIPAddresses.ipsBetween("20.0.0.10", "20.0.1.0"));
        System.out.println(CountIPAddresses.ipsBetween("0.0.0.0", "255.255.255.255"));
    }
}