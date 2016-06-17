package acm.domestic.y2010;

import java.util.Scanner;

public class QaBorderSize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int hmax = 250, hmin = 250, wmax = 250, wmin = 250;
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[][] map = new int[1000][2];
            map[0] = new int[]{250, 250};
            int[] dir = new int[]{1, 0, -1, 0, 1};
            for (int i = 1; i < n; i++) {
                int k = sc.nextInt();
                int d = sc.nextInt();
                int dx = map[k][0];
                int dy = map[k][1];
                map[i] = new int[]{dx + dir[d], dy + dir[d + 1]};
                hmax = Math.max(map[i][1], hmax);
                hmin = Math.min(map[i][1], hmin);
                wmax = Math.max(map[i][0], wmax);
                wmin = Math.min(map[i][0], wmin);
            }
            // arrayDump(map);
            System.out.println((wmax - wmin + 1) + " " + (hmax - hmin + 1));
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
