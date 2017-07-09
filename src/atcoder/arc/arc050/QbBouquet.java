package atcoder.arc.arc050;

import java.util.Scanner;

public class QbBouquet {
    static long R, B, x, y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextLong();
        B = sc.nextLong();
        x = sc.nextLong();
        y = sc.nextLong();

        long t = Long.MAX_VALUE / 2;
        long tUp = Long.MAX_VALUE;
        long tDown = 0;

        // for (int i = 0; i < Math.max(R, QbColorfulHats); i++) { System.out.println(i + ": " + (canCreate(i) ? "OK" : "NO")); }

        while (tUp - tDown >= 2) {
            // System.out.println(t);
            if (canCreate(t)) {
                tDown = t;
            } else {
                tUp = t;
            }
            t = tDown + (tUp - tDown) / 2;
        }
        System.out.println(tDown);
    }

    public static boolean canCreate(long n) {
        long rLeast = R - n;
        long bLeast = B - n;
        if (rLeast < 0 || bLeast < 0) {
            return false;
        }
        long rx = rLeast / (x - 1);
        long bx = bLeast / (y - 1);

        return rx + bx >= n;
    }

}
