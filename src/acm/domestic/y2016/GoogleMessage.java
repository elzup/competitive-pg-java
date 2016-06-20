package acm.domestic.y2016;

import java.util.*;

public class GoogleMessage {
    static int H, W;
    static int[] dir;
    static char[][] map;
    static boolean[][] done;

    static String ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        dir = new int[]{0, 1, 0, -1, 0};
        map = new char[H][W];
        done = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            String line = sc.next();
            for (int j = 0; j < W; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        dfs(0, 0, "");
        System.out.println(ans);
    }

    static void dfs(int x, int y, String s) {
        if (x < 0 || x >= W || y < 0 || y >= H || map[y][x] == '*' || done[y][x]) {
            return;
        }
        done[y][x] = true;
        if (map[y][x] != '+') {
            s += map[y][x] + "";
        }
        if (y == H - 1 && x == W - 1) {
            ans = s;
            return;
        }
        for (int i = 0; i < 4; i++) {
            dfs(x + dir[i], y + dir[i + 1], s);
        }
    }
}
