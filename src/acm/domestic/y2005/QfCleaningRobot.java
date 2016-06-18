package acm.domestic.y2005;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

// bit DP, セールスマン, bfs
public class QfCleaningRobot {
    static int W, H;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            W = sc.nextInt();
            H = sc.nextInt();
            if ((W | H) == 0) {
                break;
            }
            map = new int[H][W];
            Point ps = new Point(0, 0);
            int dtc = 0;

            for (int i = 0; i < H; i++) {
                String line = sc.next();
                for (int j = 0; j < W; j++) {
                    if (line.charAt(j) == 'o') {
                        ps.y = i;
                        ps.x = j;
                    }
                    if (line.charAt(j) == '*') {
                        map[i][j] = 1;
                        dtc++;
                    }
                    if (line.charAt(j) == 'x') {
                        map[i][j] = 2;
                    }
                }
            }
            Point[] dts = new Point[dtc];
            int l = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == 1) {
                        dts[l] = new Point(i, j);
                        l++;
                    }
                }
            }
            int[][] dis = new int[dtc][dtc];
            for (int i = 0; i < dtc; i++) {
                for (int j = i + 1; j < dtc; j++) {
                    dis[j][i] = dis[i][j] = bfs(dts[i], dts[j]);
                }
            }
            int[][] dp = new int[1 << dtc][dtc];
            for (int i = 0; i < (1 << dtc); i++) {
                Arrays.fill(dp[i], 10000);
            }
            boolean noGoal = false;
            for (int i = 0; i < dtc; i++) {
                dp[1 << i][i] = bfs(ps, dts[i]);
                if (dp[1 << i][i] == -1) {
                    noGoal = true;
                }
            }
            for (int i = 0; i < (1 << dtc); i++) {
                for (int j = 0; j < dtc; j++) {
                    for (int k = 0; k < dtc; k++) {
                        dp[i | (1 << k)][k] = Math.min(
                                dp[i | (1 << k)][k],
                                dp[i][j] + dis[j][k]
                        );
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < dtc; i++) {
                min = Math.min(min, dp[(1 << dtc) - 1][i]);
            }
            System.out.println(noGoal ? -1 : min);
        }
    }

    public static int bfs(Point s, Point g) {
        int[][] b = new int[H][W];
        for (int[] bs : b) {
            Arrays.fill(bs, -1);
        }
        Queue<Point> q = new ArrayDeque<>();
        q.add(s);
        int[] d = new int[]{0, 1, 0, -1, 0};
        b[s.y][s.x] = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.y == g.y && p.x == g.x) {
                return b[g.y][g.x];
            }
            for (int i = 0; i < 4; i++) {
                int nx = p.x + d[i];
                int ny = p.y + d[i + 1];
                if (nx < 0 || nx >= W || ny < 0 || ny >= H) {
                    continue;
                }
                if (map[ny][nx] == 2) {
                    continue;
                }
                if (b[ny][nx] >= 0 && b[ny][nx] <= b[p.y][p.x] + 1) {
                    continue;
                }
                b[ny][nx] = b[p.y][p.x] + 1;
                q.add(new Point(ny, nx));
            }
        }
        return -1;
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

    static class Point {
        public int y, x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
