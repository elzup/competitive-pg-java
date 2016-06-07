package acm.domestic.y2009;

import java.util.Scanner;

public class QbHowManyIsland {
    static int[][] map;
    static int h, w;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if ((h | w) == 0) { break; }
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int c = 0;
            // arrayDump(map);
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        fill(i, j);
                        // arrayDump(map);
                        c++;
                    }
                }
            }
            System.out.println(c);
        }
    }

    private static void fill(int y, int x) {
        if (y < 0 || x < 0 || y >= h || x >= w || map[y][x] == 0) {
            return;
        }
        map[y][x] = 0;
        for (int dx = -1; dx < 2; dx++) {
            for (int dy = -1; dy < 2; dy++) {
                if ((dx | dy) == 0) {
                    continue;
                }
                fill(y + dy, x + dx);
            }
        }
    }
}
