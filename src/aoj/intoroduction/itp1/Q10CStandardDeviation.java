package aoj.intoroduction.itp1;

import java.util.Scanner;

public class Q10CStandardDeviation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TODO: 誤差が大きくて WA

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            double a2 = 0;
            int[] k = new int [n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                k[i] = sc.nextInt();
                sum += k[i];
            }
            int avg = sum / n;
            for (int i = 0; i < n; i++) {
                a2 += Math.pow(k[i] - avg, 2);
            }
            double a = Math.sqrt(a2 / n);
            System.out.println(a);
        }
    }
}
