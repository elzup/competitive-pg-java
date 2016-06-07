package acm.domestic.y2006;

import java.util.Scanner;

public class QaMisteriousgems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            int[][] sp = new int[21][21];
            for (int i = 0; i < n; i++) {
                sp[sc.nextInt()][sc.nextInt()] = 1;
            }
            int m = sc.nextInt();
            int px = 10;
            int py = 10;
            int c = 0;
            for (int i = 0; i < m; i++) {
                String dir = sc.next();
                int d = sc.nextInt();
                int dx = 0;
                int dy = 0;
                if ("N".equals(dir)) {
                    dy = 1;
                } else if ("S".equals(dir)) {
                    dy = -1;
                } else if ("E".equals(dir)) {
                    dx = 1;
                } else {
                    dx = -1;
                }
                for (int j = 0; j < d; j++) {
                    px += dx;
                    py += dy;
                    if (sp[px][py] == 1) {
                        c++;
                        sp[px][py] = 0;
                    }
                }
            }
            System.out.println(c == n ? "Yes" : "No");
        }
    }
}
