package atcoder.abc.abc039;

import java.util.Scanner;

public class QdFlippable {
    static int H, W;
    static int[][] map, tmap;
    static boolean[][] fills;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        map = new int[H][W];
        tmap = new int[H][W];
        fills = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            String line = sc.next();
            for (int j = 0; j < W; j++) {
                if (line.charAt(j) == '#') {
                    map[i][j] = 1;
                    tmap[i][j] = 1;
                }
            }
        }
        // arrayDump(map);
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                fill(i, j);
            }
        }
//        arrayDump(map);
        if (check()) {
            System.out.println("possible");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(fills[i][j] ? "#": ".");
                }
                System.out.println();
            }
        } else {
            System.out.println("impossible");
        }

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

    static void fill(int y, int x) {
        for (int dy = -1; dy < 2; dy++) {
            for (int dx = -1; dx < 2; dx++) {
                if (y + dy < 0 || y + dy >= H || x + dx < 0 || x + dx >= W) {
                    continue;
                }
                if (tmap[y + dy][x + dx] < 1) {
                    return;
                }
            }
        }
        for (int dy = -1; dy < 2; dy++) {
            for (int dx = -1; dx < 2; dx++) {
                if (y + dy < 0 || y + dy >= H || x + dx < 0 || x + dx >= W) {
                    continue;
                }
                map[y + dy][x + dx] = 2;
            }
        }
        fills[y][x] = true;
    }

    static boolean check() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
