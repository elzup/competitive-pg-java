package acm.kyusyu2011;

import java.util.Scanner;

public class Main {
    static int h, w, s, allSum, limit;
    static int[][] u;

    static int[][][][] memo;
    static int[][][][] dpMemo;
    static int[][] ss;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        s = sc.nextInt();
        u = new int[h][w];
        ss = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                u[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0) {
                    if (j == 0) {
                        ss[i][j] = u[i][j];
                        continue;
                    }
                    ss[i][j] = ss[i][j - 1] + u[i][j];
                    continue;
                }
                if (j == 0) {
                    ss[i][j] = ss[i - 1][j] + u[i][j];
                    continue;
                }
                ss[i][j] = ss[i - 1][j] + ss[i][j - 1] - ss[i - 1][j - 1] + u[i][j];
            }
        }
        // arrayDump(u);
        // arrayDump(ss);
        memo = new int[h][w][h][w];
        dpMemo = new int[h][w][h][w];
        allSum = ss[h - 1][w - 1];
        limit = allSum - s;
        System.out.println("limit: " + limit);
        int res = dp(0, 0, h - 1, w - 1);
        System.out.println(res);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(dpMemo[i][j][i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int dp(int y1, int x1, int y2, int x2) {
        if (dpMemo[y1][x1][y2][x2] != 0) {
            return dpMemo[y1][x1][y2][x2];
        }
        if (areaSum(y1, x1, y2, x2) < limit) {
            return Integer.MIN_VALUE;
        }
        int max = 1;
        for (int i = y1; i < y2 - 1; i++) {
            max = Math.max(max, dp(y1, x1, i, x2) + dp(i + 1, x1, y2, x2));
        }
        for (int i = x1; i < x2 - 1; i++) {
            max = Math.max(max, dp(y1, x1, y2, i) + dp(y1, i + 1, y2, x2));
        }
        dpMemo[y1][x1][y2][x2] = max;
        return max;
    }

    public static int areaSum(int y1, int x1, int y2, int x2) {
        if (memo[y1][x1][y2][x2] == 0) {
            memo[y1][x1][y2][x2] = ss[y2][x2] - ss[y1][x2] - ss[y2][x1] + ss[y1][x1];
        }
        return memo[y1][x1][y2][x2];
    }

    public static void arrayDump(int[][] a) {
        for (int i = 0, l = a.length; i < l; i++) {
            for (int j = 0, l2 = a[0].length; j < l2; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
