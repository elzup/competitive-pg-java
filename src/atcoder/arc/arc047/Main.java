package atcoder.arc.arc047;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] pos = new long[n][2];
        long xTop = Integer.MIN_VALUE;
        long xLow = Integer.MAX_VALUE;
        long yTop = Integer.MIN_VALUE;
        long yLow = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            pos[i] = new long[]{x + y, x - y};
            xTop = Math.max(xTop, pos[i][0]);
            xLow = Math.min(xLow, pos[i][0]);
            yTop = Math.max(yTop, pos[i][1]);
            yLow = Math.min(yLow, pos[i][1]);
            // pos[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }
        // System.out.println("[" + xTop + ", " + yTop + "] [" + xLow + ", " + yLow + "]");
        long ox = xTop;
        long oy = yTop;
        if (xTop != xLow && yTop != yLow) {
            long xd = (xTop - xLow) / 2;
            long yd = (yTop - yLow) / 2;
            long r;
            if (xd > yd) {
                r = xd;
                ox = xTop - r;
                oy = yTop - r;
            } else {
                r = yd;
                ox = xTop - r;
                oy = yTop - r;
            }
            // System.out.println(r);
            // System.out.println("a: ");
        } else if (yTop != yLow) {
            long yd = (yTop - yLow) / 2;
            long r = yd / 2;
            ox = xTop - r;
            oy = yTop - r;
            // System.out.println("b: ");
        } else if (xTop != xLow) {
            long xd = (xTop - xLow) / 2;
            long r = xd / 2;
            ox = xTop - r;
            oy = yTop - r;
            // System.out.println("c: ");
        }
        // System.out.println("{" + ox + ", " + oy + "}");
        long tx = (ox + oy) / 2;
        long ty = (ox - oy) / 2;
        System.out.println(tx + " " + ty);
    }
}
