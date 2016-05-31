package acm.kyusyu2011;

import java.util.Scanner;

// 二次 総和 メモ化 DP
public class QePlanningBlackout {
    static int h, w, s, allSum, limit;
    static int[][] u;

    static int[][][][] memo;
    static int[][][][][] dpMemo;
    static int[][] ss;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            h = sc.nextInt();
            w = sc.nextInt();
            s = sc.nextInt();
            if ((h | w | s) == 0) {
                break;
            }
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
            dpMemo = new int[h][w][h][w][2];
            allSum = ss[h - 1][w - 1];
            limit = allSum - s;
            // System.out.println("limit: " + limit);
            int[] res = dp(0, 0, h - 1, w - 1);
            // int k = 1;
            // for (int i = 0; i < h - k; i++) {
            //     for (int j = 0; j < w - k; j++) {
            //         // System.out.print(areaSum(i, j, i + k, j + k) + " ");
            //         System.out.print(dp(i, j, i + k, j + k) + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
            System.out.println(res[0] + " " + res[1]);
        }
    }

    public static int[] dp(int y1, int x1, int y2, int x2) {
        if (dpMemo[y1][x1][y2][x2][0] != 0) {
            return dpMemo[y1][x1][y2][x2];
        }
        int as = areaSum(y1, x1, y2, x2);
        if (as < limit) {
            return new int[]{-1, Integer.MAX_VALUE};
        }
        int max = 1;
        int subs = as - limit;
        for (int i = y1; i < y2; i++) {
            int[] as1 = dp(y1, x1, i, x2);
            int[] as2 = dp(i + 1, x1, y2, x2);
            if (as1[0] == -1 || as2[0] == -1) {
                continue;
            }
            int asum = as1[0] + as2[0];
            int asub = Math.min(as1[1], as2[1]);
            if (max < asum || (max == asum && subs < asub)) {
                max = asum;
                subs = asub;
            }
        }
        for (int i = x1; i < x2; i++) {
            int[] as1 = dp(y1, x1, y2, i);
            int[] as2 = dp(y1, i + 1, y2, x2);
            if (as1[0] == -1 || as2[0] == -1) {
                continue;
            }
            int asum = as1[0] + as2[0];
            int asub = Math.min(as1[1], as2[1]);
            if (max < asum || (max == asum && subs < asub)) {
                max = asum;
                subs = asub;
            }
        }
        dpMemo[y1][x1][y2][x2][0] = max;
        dpMemo[y1][x1][y2][x2][1] = subs;
        return dpMemo[y1][x1][y2][x2];
    }

    public static int areaSum(int y1, int x1, int y2, int x2) {
        if (memo[y1][x1][y2][x2] == 0) {
            if (y1 == 0 && x1 == 0) {
                memo[y1][x1][y2][x2] = ss[y2][x2];
            } else if (y1 == 0) {
                memo[y1][x1][y2][x2] = ss[y2][x2] - ss[y2][x1 - 1];
            } else if (x1 == 0) {
                memo[y1][x1][y2][x2] = ss[y2][x2] - ss[y1 - 1][x2];
            } else {
                memo[y1][x1][y2][x2] = ss[y2][x2] - ss[y1 - 1][x2] - ss[y2][x1 - 1] + ss[y1 - 1][x1 - 1];
            }
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
