package atcoder.abc.abc006;

import java.util.Scanner;

public class Trump1 {
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (n > 16) {
            return;
        }
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        int m = 300000;
        for (int k = 0; k < Math.pow(2, n); k++) {
            if (check(c, k)) {
                m = Math.min(m, n - Integer.bitCount(k));
            }
        }
        System.out.println(m);
    }

    public static boolean check(int[] a, int k) {
        int s = 0;
        for (int j = 0; j < n; j++) {
            if (((k >> j) & 1) == 0) {
                continue;
            }
            if (s > a[j]) {
                return false;
            }
            s = a[j];
        }
        return true;
    }
}
