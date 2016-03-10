package atcoder.abc.abc008;

import java.util.Scanner;

public class QcMajority {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] c = new int[n];
        double s = (double) n / 2;
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int d = 0;
            for (int j = 0; j < n; j++) {
                if (c[i] % c[j] == 0) {
                    d += 1;
                }
            }
            if (d % 2 == 1) {
                s += (d + 1) * 0.5d / d - 0.5d;
            }
        }
        System.out.println(s);
    }

    public static void arrayDump(int[] k) {
        for (int i = 0; i < k.length; i++) {
            System.out.print(String.format("%3d", k[i]));
        }
        System.out.println();
    }
}
