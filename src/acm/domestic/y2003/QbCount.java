package acm.domestic.y2003;

import java.util.Scanner;

public class QbCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                return;
            }
            int w = sc.nextInt();
            int h = sc.nextInt();
            int[][] map = new int[h][w];
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                map[y][x] = 1;
            }
            int s = sc.nextInt();
            int t = sc.nextInt();
            int max = 0;
            int[][] rbmap = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    rbmap[i][j] = map[i][j];
                    if (i == 0 && j == 0) {
                    } else if (i == 0) {
                        rbmap[i][j] += rbmap[i][j - 1];
                    } else if (j == 0) {
                        rbmap[i][j] += rbmap[i - 1][j];
                    } else {
                        rbmap[i][j] += rbmap[i - 1][j] + rbmap[i][j - 1] - rbmap[i - 1][j - 1];
                    }
                }
            }
            // arrayDump(rbmap);
            for (int i = 0; i <= h - t; i++) {
                for (int j = 0; j <= w - s; j++) {
                    int c = rbmap[i + t - 1][j + s - 1];
                    if (i == 0 && j == 0) {
                    } else if (i == 0) {
                        c -= rbmap[i + t - 1][j - 1];
                    } else if (j == 0) {
                        c -= rbmap[i - 1][j + s - 1];
                    } else {
                        c += - rbmap[i + t - 1][j - 1] - rbmap[i - 1][j + s - 1] + rbmap[i - 1][j - 1];
                    }
                    // System.out.print(c + " ");
                    max = Math.max(c, max);
                }
                // System.out.println();
            }
            System.out.println(max);
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
}
