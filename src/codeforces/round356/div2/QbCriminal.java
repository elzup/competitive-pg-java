package codeforces.round356.div2;

import java.util.Scanner;

public class QbCriminal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt() - 1;
        int[] a = new int[n];

        int r = Math.min(p, n - p - 1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (Math.abs(i - p) > r) {
                res += a[i];
            }
        }
        res += a[p];
        for (int i = 1; i <= r; i++) {
            if (a[p - i] + a[p + i] == 2) {
                res += 2;
            }
        }
        System.out.println(res);
    }
}
