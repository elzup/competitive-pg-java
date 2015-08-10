package paiza;

import java.util.Scanner;

public class S002Shortest {
    static int[][] map;
    static int[][] pMap;
    static int M, N;
    final static int INF = -1;

    final static int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[N][M];
        pMap = new int[N][M];
        sc.nextLine();
        int sy = 0, sx = 0, ey = 0, ex = 0;
        for (int i = 0; i < N; i++) {
            String[] vals = sc.nextLine().split(" ");
            for (int j = 0; j < M; j++) {
                pMap[i][j] = INF;
                String v = vals[j];
                if ("s".equals(v)) {
                    sy = i;
                    sx = j;
                } else if ("g".equals(v)) {
                    ey = i;
                    ex = j;
                } else {
                    map[i][j] = Integer.parseInt(v);
                    continue;
                }
                map[i][j] = -1;
            }
        }
        // arrayDump(pMap);
        calc(sx, sy, 0);
        // arrayDump(pMap);
        if (pMap[ey][ex] == INF) {
            System.out.println("Fail");
            return;
        }
        System.out.println(pMap[ey][ex]);
    }

    public static void arrayDump(int[][] k) {
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                System.out.printf("%2d", k[i][j]);
            }
            System.out.println();
        }
        System.out.println("---");
    }

    public static void calc(int x, int y, int p) {
        // System.out.printf("to: %d, %d [%d : %d]\n", x, y, p, pMap[y][x]);
        if (map[y][x] == 1 || (pMap[y][x] != INF && pMap[y][x] <= p)) {
            return;
        }
        pMap[y][x] = p;
        for (int i = 0, l = dirs.length; i < l; i++) {
            int px = dirs[i][0] + x;
            int py = dirs[i][1] + y;
            // System.out.println(px + ":" + py);
            if (px < 0 || M <= px || py < 0 || N <= py) {
                continue;
            }
            calc(px, py, p + 1);
        }
    }

}
