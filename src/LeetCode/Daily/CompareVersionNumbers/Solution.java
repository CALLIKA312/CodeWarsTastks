package LeetCode.Daily.CompareVersionNumbers;

class Solution {
    public static int compareVersion(String version1, String version2) {
        String[] v1Sep = version1.split("\\.");
        String[] v2Sep = version2.split("\\.");
        int v1SepL = v1Sep.length;
        int v2SepL = v2Sep.length;
        int minL = Math.min(v1SepL, v2SepL);
        if (minL == 1) {
            if (v1SepL == v2SepL)
                return Integer.compare(getV1SepI(v1Sep, 0), getV2SepI(v2Sep, 0));

            if (getV1SepI(v1Sep, 0) > getV2SepI(v2Sep, 0)) return 1;
            else if (getV1SepI(v1Sep, 0) < getV2SepI(v2Sep, 0)) return -1;

            if (v1SepL == 1) {
                for (int i = 1; i < v2SepL; i++)
                    if (getV2SepI(v2Sep, i) != 0) return -1;
            } else {
                for (int i = 1; i < v1SepL; i++)
                    if (getV1SepI(v1Sep, i) != 0) return 1;
            }
            return 0;
        }
        int ans = 0;
        int i = 0;
        for (; i < minL; i++) {
            int diff = getV1SepI(v1Sep, i) - getV2SepI(v2Sep, i);
            if (diff < 0) return -1;
            else if (diff > 0) return 1;
        }
        if (minL != v1SepL) {
            for (; i < v1SepL; i++)
                if (getV1SepI(v1Sep, i) != 0) return 1;
        } else if (minL != v2SepL) {
            for (; i < v2SepL; i++)
                if (getV2SepI(v2Sep, i) != 0) return -1;
        }
        return ans;
    }

    public static int getV1SepI(String[] v1Sep, int i) {
        return Integer.parseInt(v1Sep[i]);
    }

    public static int getV2SepI(String[] v2Sep, int i) {
        return Integer.parseInt(v2Sep[i]);
    }

    public static void main(String[] args) {
        String version1 = "10.3";
        String version2 = "11";
        System.out.println(compareVersion(version1, version2));
    }
}
