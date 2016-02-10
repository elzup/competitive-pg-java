package atcoder.abc006;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int n;

    // Longest Increasing Subsequence LIS 最長増加部分列
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        sc.close();

        // arrayDump(c);

        int[] lis = new int[n + 1];
        lis[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            lis[i] = Integer.MAX_VALUE;
        }
        int m = 1;
        for (int i = 0; i < n; i++) {
            int p = ~Arrays.binarySearch(lis, c[i]);
            lis[p] = c[i];
            // System.out.println(i);
            // arrayDump(lis);
            m = Math.max(m, p);
            // System.out.println(m);
        }

        System.out.println(n - m);
    }

    public static void arrayDump(int[] a) {
        for (int i = 0, l = a.length; i < l; i++) {
            System.out.printf("%3d", a[i]);
        }
        System.out.println();
    }
}
