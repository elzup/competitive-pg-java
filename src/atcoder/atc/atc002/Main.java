package atcoder.atc.atc002;

import java.util.Scanner;

public class Main {
    static int[] w;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        int[] res = dp(0, n - 1, 1, 0, n - 1);
        System.out.println(res[0]);
    }

    public static int[] dp(int s, int e, int dep, int sp, int ep) {
        // System.out.println("=" + dep + "  " + s + ", " + e);
        int min = Integer.MAX_VALUE;
        int p = s;
        for (int i = sp; i < ep; i++) {
            int t = 0;
            if (i == s) {
                t += dep * w[i];
            } else {
                int[] res = dp(s, i, dep + 1, sp, i);
                t += res[0];
                sp = res[1];
            }
            if (i + 1 == e) {
                t += dep * w[i + 1];
            } else {
                int[] res = dp(i + 1, e, dep + 1, i + 1, ep);
                t += res[0];
                ep = res[1] + 1;
            }
            if (t <= min) {
                min = t;
                p = i;
            }
        }
        return new int[] { min, p };
    }
}
