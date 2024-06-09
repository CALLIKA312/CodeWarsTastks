package LeetCode.BC131.C;

import java.util.*;

class Solution {
    /*public static int[] queryResults(int limit, int[][] queries) {
        int[] ans = new int[queries.length];
        int curColors = 0;
        HashMap<Integer, Integer> balls = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            //Проверили есть ли шарики с такими цветами
            if (balls.containsValue(query[1])) {
                //Если у шарика был другой цвет, то --
                if (balls.getOrDefault(query[0], 0) != query[1]) {
                    curColors--;
                    //Если у шарика был тот же цвет, то ничего
                } else {
                }
            } else {
                //Покрасили старый шарик в новый цвет
                //Проверка, что у других шаров нет этого цвета
                for (Map.Entry<Integer, Integer> ball : balls.entrySet())
                    if (ball.getValue() != query[0] && ball.getValue().equals(balls.get(query[0])) && ball.getValue() != query[1]) {
                        curColors++;
                        break;
                    }
            }
            //Покрасили новый шарик
            if (!balls.containsKey(query[0])) curColors++;

            balls.put(query[0], query[1]);
            ans[i] = curColors;
        }
        return ans;
    }*/

    public static int[] queryResults(int limit, int[][] queries) {
        int[] ans = new int[queries.length];
        int curColors = 0;
        int[] balls = new int[limit + 1];
        Arrays.fill(balls, 0);
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int state = 0;
            for (int j = 0; j < balls.length; j++) {
                if (j == query[0]) continue;
                int ball = balls[j];
                //Ищем, есть ли у других шаров такой цвет
                if (ball == query[1]) {
                    //Если наш шар был не такого цвета, то --
                    if (balls[query[0]] != query[1]) {
                        state = -1;
                    } else {
                        if (balls[query[0]] == 0) {
                            state = 1;
                        }
                        if (balls[query[0]] == ball && balls[query[0]] != query[1]) {
                            state = 1;
                        }
                    }
                }
            }
            switch (state) {
                case -1:
                    curColors--;
                    break;
                case 1:
                    curColors++;
                    break;
            }
            balls[query[0]] = query[1];
            ans[i] = curColors;
        }
        return ans;
    }

    public static void main(String[] args) {
        int limit = 4;
        int[][] queries = {{1, 4}, {2, 5}, {1, 3}, {3, 4}};
        //System.out.println(Arrays.toString(queryResults(limit, queries)));
        limit = 1;
        queries = new int[][]{{0, 1}, {1, 4}, {1, 1}, {1, 4}, {1, 1}};
        System.out.println(Arrays.toString(queryResults(limit, queries)));
    }

}
