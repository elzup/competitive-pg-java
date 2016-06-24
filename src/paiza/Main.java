package paiza;

import java.util.Scanner;

public class Main {
    static int N;
    static int[] dir = new int[] { 1, 1, -1, -1, 1 };
    static int[][][][][] memo;
    static boolean[][][][][] done;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int ex = sc.nextInt();
        int ey = sc.nextInt();
        memo = new int[N][N][N][N][2];
        done = new boolean[N][N][N][N][2];
        System.out.println(dp(y, x, ey, ex, true));
    }

    static int dp(int y, int x, int ey, int ex, boolean isMy) {
        if (y < 0 || x < 0 || ey < 0 || ex < 0
                || y >= N || x >= N || ey >= N || ex >= N) {
            return -1;
        }
        done[y][x][ey][ex][isMy ? 1 : 0] = true;
        if (memo[y][x][ey][ex][isMy ? 1 : 0] != 0) {
            return memo[y][x][ey][ex][isMy ? 1 : 0];
        }
        if (y == ey && x == ex) {
            return isMy ? Integer.MAX_VALUE : 0;
        }
        int diff = diff(y, x, ey, ex);
        int c = 0;
        if (isMy) {
            c = Integer.MAX_VALUE;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if ((i | j) == 0) {
                        continue;
                    }
                    if (diff < diff(y + i, x + j, ey, ex)) {
                        continue;
                    }
                    int p = dp(y + i, x + j, ey, ex, false);
                    if (p == -1) {
                        continue;
                    }
                    c = Math.min(c, p);
                }
            }
            if (c == Integer.MAX_VALUE) {
                c = -1;
            }
            return memo[y][x][ey][ex][1] = c + 1;
        } else {
            c = Integer.MIN_VALUE;
            for (int i = 0; i < 4; i++) {
                int p = dp(y, x, ey + dir[i], ex + dir[i + 1], true);
                if (p == -1) {
                    continue;
                }
                c = Math.max(c, p);
            }
            if (c == Integer.MIN_VALUE) {
                c = -1;
            }
            return memo[y][x][ey][ex][0] = c;
        }
    }

    static int diff(int y, int x, int ey, int ex) {
        return Math.abs(y - ey) + Math.abs(x - ex);
    }
}
