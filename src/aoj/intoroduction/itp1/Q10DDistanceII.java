package aoj.intoroduction.itp1;

import java.util.Scanner;

public class Q10DDistanceII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        double d1 = 0, d2 = 0, d3 = 0;
        int dm = 0;
        for (int i = 0; i < n; i++) {
            int d = Math.abs(a[i] - b[i]);
            d1 += d;
            d2 += d * d;
            d3 += d * d * d;
            dm = Math.max(dm, d);
            // System.out.printf("%f %f %f %f\n", d1, d2, d3, (float) dm);
        }
        d2 = Math.sqrt(d2);
        d3 = Math.cbrt(d3);
        System.out.printf("%f\n%f\n%f\n%f\n", d1, d2, d3, (float) dm);
    }
}
