package acm.kyusyu2011;

import java.util.ArrayList;
import java.util.Scanner;

public class QcFillPanel {
    static int h, w, c;
    static int[][] map;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            h = sc.nextInt();
            w = sc.nextInt();
            c = sc.nextInt();
            if ((h | w | c) == 0) {
                break;
            }
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            max = Integer.MIN_VALUE;
            dp(1);
            System.out.println(max);
        }

    }

    public static void dp(int k) {
        int col = map[0][0];
        if (k == 5) {
            if (col == c) {
                return;
            }
            ArrayList<Point> pos = new ArrayList<>();
            fill(0, 0, col, c, pos);
            ArrayList<Point> pos2 = new ArrayList<>();
            fill(0, 0, c, 10, pos2);
            for (Point p : pos2) {
                map[p.y][p.x] = c;
            }
            for (Point p : pos) {
                map[p.y][p.x] = col;
            }
            max = Math.max(pos2.size(), max);
            return;
        }
        for (int i = 1; i <= 6; i++) {
            if (i == col) {
                continue;
            }
            ArrayList<Point> pos = new ArrayList<>();
            fill(0, 0, col, i, pos);
            dp(k + 1);
            for (Point p : pos) {
                map[p.y][p.x] = col;
            }
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

    public static void fill(int y, int x, int colFrom, int colTo, ArrayList<Point> pos) {
        if (y < 0 || x < 0 || y >= h || x >= w) {
            return;
        }
        if (map[y][x] != colFrom) {
            return;
        }
        map[y][x] = colTo;
        pos.add(new Point(y, x));
        fill(y + 1, x, colFrom, colTo, pos);
        fill(y - 1, x, colFrom, colTo, pos);
        fill(y, x + 1, colFrom, colTo, pos);
        fill(y, x - 1, colFrom, colTo, pos);
    }

    public static class Point {
        int x;
        int y;

        Point(int y, int x) {
            this.x = x;
            this.y = y;
        }

    }
}
