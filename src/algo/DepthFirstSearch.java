package algo;

import java.util.Scanner;

// 深さ優先探索
public class DepthFirstSearch {
    private static int h, w;
    private static String[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        int sx = 0, sy = 0, ex = 0, ey = 0;
        map = new String[h][w];
        for (int i = 0; i < h; i++) {
            String line = sc.next();
            for (int j = 0; j < w; j++) {
                map[i][j] = "" + line.charAt(j);
                if (map[i][j].equals("s")) {
                    sx = j;
                    sy = i;
                    map[i][j] = ".";
                } else if (map[i][j].equals("g")) {
                    ex = j;
                    ey = i;
                    map[i][j] = ".";
                }
            }
        }
        fill(sy, sx);
        System.out.println(map[ey][ex].equals("x") ? "Yes" : "No");
    }

    private static void fill(int y, int x) {
        if (y < 0 || x < 0 || y >= h || x >= w
                || !map[y][x].equals(".")) {
            return;
        }
        map[y][x] = "x";
        fill(y + 1, x    );
        fill(y    , x + 1);
        fill(y - 1, x    );
        fill(y    , x - 1);
    }
}
