package acm.ehime2004;

import java.util.Scanner;

public class QbRedBlack2 {
    static int[][] map;
    static int h, w, c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if ((w | h) == 0) {
                break;
            }
            int sx = 0;
            int sy = 0;
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                String line = sc.next();
                for (int j = 0; j < w; j++) {
                    char c = line.charAt(j);
                    switch (c) {
                        case '.':
                            map[i][j] = 0;
                            break;
                        case '#':
                            map[i][j] = 1;
                            break;
                        case '@':
                            sy = i;
                            sx = j;
                            map[i][j] = 0;
                    }
                }
            }
            c = 0;
            dfs(sy, sx);
            System.out.println(c);
        }
    }

    static void dfs(int y, int x) {
        if (y < 0 || x < 0 || y >= h || x >= w) {
            return;
        }
        if (map[y][x] == 1) {
            return;
        }
        map[y][x] = 1;
        c++;
        dfs(y - 1, x);
        dfs(y + 1, x);
        dfs(y, x - 1);
        dfs(y, x + 1);
    }
}
