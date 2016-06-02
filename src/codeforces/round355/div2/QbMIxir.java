package codeforces.round355.div2;

import java.util.Scanner;

public class QbMIxir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long h = sc.nextLong();
        long k = sc.nextLong();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        long ch = 0;
        int i = 0;
        long t = 0;
        while (i < n) {
            while (i < n && ch + a[i] <= h) {
                ch += a[i];
                i ++;
            }
            if (ch >= k) {
                t += ch / k;
                ch %= k;
            } else {
                t ++;
                ch = 0;
            }
        }
        if (ch > 0) {
            t ++;
        }
        System.out.println(t);
    }
}
