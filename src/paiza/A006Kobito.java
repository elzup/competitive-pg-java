package paiza;

import java.util.Scanner;

public class A006Kobito {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] p = new int[n][2];
        boolean[][] map = new boolean[500][500];
        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < 500; j++) {
                map[j][i] = false;
            }
        }
        int ox = 250;
        int oy = 250;
        for (int i = 0; i < n; i++) {
            p[i][1] = sc.nextInt();
            p[i][0] = sc.nextInt();
        }
        int i = 0;
        int l = 0;
        while (true) {
            int[] d = circlePos(i);
            // System.out.println(i + "_");
            // System.out.println(d[1] + "," + d[0]);
            // for (int[] pn : p) {
            for (int j = 0; j < p.length; j++) {
                if (p[j][0] == 500) {
                    continue;
                }
                int px = ox + p[j][1] + d[1];
                int py = oy + p[j][0] + d[0];
                // System.out.println(px + "," + py);
                if (map[py][px]) {
                    l++;
                    // System.out.println("l: " + l);
                    if (l == n) {
                        System.out.println(i - 1);
                        return;
                    }
                    p[j][0] = 500;
                }
                map[py][px] = true;
            }
            i++;
        }
    }

    public static int[] circlePos(int t) {
        if (t == 0) {
            return new int[]{0, 0};
        }
        int i = 0;
        int[][] lib = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int x = 0;
        int y = 0;
        int k = 0;
        while (true) {
            int[] dl = lib[k % 4];
            for (int j = 0, l = k / 2 + 1; j < l; j++) {
                x += dl[1];
                y += dl[0];
                i++;
                // System.out.println(i + ": " + x + "," + y);
                if (t == i) {
                    return new int[]{y, x};
                }
            }
            k ++;
        }
    }
}
