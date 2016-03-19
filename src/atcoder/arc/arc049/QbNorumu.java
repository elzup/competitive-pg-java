package atcoder.arc.arc049;

import java.util.Scanner;

public class QbNorumu {
    static int n;
    static int[][] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        p = new int[n][3];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int c = sc.nextInt();
            p[i][0] = x;
            p[i][1] = y;
            p[i][2] = c;
        }
        int ts = 0;
        int te = 100000;
        int t = (te - ts) / 2;
        while (true) {
            System.out.println(t + ", (" + ts + " -> " + te + ")");
            if (canSpot(t)) {
                te -= (te - ts) / 2;
            } else {
                ts += (te - ts) / 2;
            }
            t = ts + (te - ts) / 2;
            if (te - ts < 2) {
                break;
            }
        }
        System.out.println(t + 1);
    }

    public static boolean canSpot(int t) {
        double xs = 1000000;
        double xe = -1000000;
        double ys = 1000000;
        double ye = -1000000;
        for (int i = 0; i < n; i++) {
            double x = p[i][0];
            double y = p[i][1];
            double tc = p[i][2] * t;
            xs = Math.min(xs, x + tc);
            xe = Math.max(xe, x - tc);
            ys = Math.min(ys, y + tc);
            ye = Math.max(ye, y - tc);
        }
        System.out.println(xs + ", " + xe + ", " + ys + ", " + ye);
        return xs >= xe && ys >= ye;
    }

    // public static int distance(int x1, int y1, int x2, int y2) {
    //     return Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
    // }
}
