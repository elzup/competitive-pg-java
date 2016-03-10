package atcoder.abc.abc006;

import java.util.Scanner;

public class Trump2 {
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (n > 1000) {
            return;
        }
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        sc.close();

        // arrayDump(c);

        int[] lis = new int[n];
        lis[0] = 1;
        int m = 1;
        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (c[j] < c[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                    // System.out.println(m  + ":" + lis[i]);
                    m = Math.max(m, lis[i]);
                }
            }
            // System.out.println(i);
            // arrayDump(lis);
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
