package atcoder.abc.abc037;

import java.util.Scanner;

public class QdRoutes {

    static int[] dx = new int[] { 1, 0, -1,  0 };
    static int[] dy = new int[] { 0, 1,  0, -1 };
    static int[][] a;
    static int h, w;
    static int[][] dp;

    static int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        a = new int[h][w];
        dp = new int[h][w];
        for (int j = 0; j < h; j++) {
            for (int i = 0; i < w; i++) {
                a[j][i] = sc.nextInt();
                dp[j][i] = -1;
            }
        }
        long res = 0;
        for (int j = 0; j < h; j++) {
            for (int i = 0; i < w; i++) {
                res = (res + count(j, i)) % MOD;
            }
        }
        System.out.println(res);
    }

    public static int count(int y, int x) {
        int sum = 1;
        if (dp[y][x] != -1) {
            return dp[y][x];
        }
        for (int i = 0; i < 4; i++) {
            int px = dx[i] + x;
            int py = dy[i] + y;
            if (!isInside(py, px) || a[py][px] <= a[y][x]) {
                continue;
            }
            sum = (sum + count(py, px)) % MOD;
        }
        dp[y][x] = sum;
        // System.out.println(y + "," + x + ": " + sum);
        return sum;
    }

    public static boolean isInside(int y, int x) {
        return 0 <= y && y < h && 0 <= x && x < w;
    }
}
