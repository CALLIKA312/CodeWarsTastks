package HumanReadableTime;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        StringBuilder result = new StringBuilder();
        int resSeconds = seconds % 60;
        int minutes = seconds / 60;
        int resMinutes = minutes % 60;
        int hours = minutes / 60;

        if (hours < 10) result.append(0).append(hours);
        else result.append(hours);
        result.append(":");
        if (resMinutes< 10) result.append(0).append(resMinutes);
        else result.append(resMinutes);
        result.append(":");
        if (resSeconds< 10) result.append(0).append(resSeconds);
        else result.append(resSeconds);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(HumanReadableTime.makeReadable(100));
        System.out.println(HumanReadableTime.makeReadable(60));
        System.out.println(HumanReadableTime.makeReadable(86399));
        System.out.println(HumanReadableTime.makeReadable(359999));
    }
}