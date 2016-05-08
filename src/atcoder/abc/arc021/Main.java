package atcoder.abc.arc021;

import java.util.Scanner;

public class Main {
    static int k, n;
    static long[] a, d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        a = new long[n];
        d = new long[n];
        // if (k > 5000 || n > 5000) {
        // if (k > 100000) {
        //     System.exit(0);
        // }
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }
        long res = -1;
        // long h = Long.MAX_VALUE;
        long h = 5000000000000000000L;
        long l = 0;
        long m = (h + l) / 2;
        while (h != l) {
            res = check(m);
            if (res == -1) {
                h = m;
            } else if (res == -2) {
                l = m;
            } else {
                break;
            }
            m = l + (h - l) / 2;
            // System.out.println(m + ": " + res);
            // System.out.println();
        }
        System.out.println(res);
    }

    // down(over): -1, up(less): -2
    public static long check(long i) {
        long sum = 0;
        long c = 0;
        long nc = 0;
        for (int j = 0; j < n; j++) {
            long an = a[j];
            while (an < i) {
                sum += an;
                // System.out.print(" +" + an);
                c++;
                if (c > k) {
                    return -1;
                }
                an += d[j];
            }
            if (an == i) {
                nc ++;
            }
        }
        long dk = k - c;
        // System.out.println();
        // System.out.println("k: " + k);
        // System.out.println("c: " + c);
        // System.out.println("dk: " + dk);
        if (dk > nc) {
            return -2;
        }
        return sum + (dk * i);
    }
}
