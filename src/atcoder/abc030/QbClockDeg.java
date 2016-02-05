package atcoder.abc030;

import java.util.Scanner;

public class QbClockDeg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double deg_m = m * 6.0d;
        double deg_n = n * 30.0d + m * 0.5d;
        double deg = (Math.abs(deg_m - deg_n)) % 360;
        if (deg >= 180) {
            deg = 360 - deg;
        }
        System.out.println(deg);
        // for (int n = 0; n < 12; n++) {
        //     for (int m = 0; m < 60; m++) {
        //         // System.out.println(n + ":" + m + "  " + );
        //     }
        // }
    }
}
