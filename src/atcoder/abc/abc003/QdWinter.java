package atcoder.abc.abc003;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class QdWinter {

    static InputStream is;
    static PrintWriter out;
    static String INPUT = "";

    final static int INF = Integer.MAX_VALUE;
    final static int MIN = Integer.MIN_VALUE;
    final static int LIM = 1000000007;

    static void solve() {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int D = sc.nextInt();
        int L = sc.nextInt();
        long comb = inComb(X, Y, D, L);
        // System.out.println(comb);

        System.out.println(comb * (R - X + 1) * (C - Y + 1) % LIM);
    }

    public static long inComb(int x, int y, int d, int l) {
        long all = comb(x * y, d + l);
        System.out.println(ignore(x, y, d + l));
        return (all - ignore(x, y, d + l)) * comb(x * y, d);
    }

    public static long ignore(int x, int y, int n) {
        long ig = 0;
        ig += comb((x - 1) *       y, n) * 2;
        ig += comb(      x * (y - 1), n) * 2;

        ig -= comb((x - 1) * (y - 1), n) * 4;
        ig -= comb((x - 2) *       y, n);
        ig -= comb(      x * (y - 2), n);

        ig += comb((x - 2) * (y - 1), n) * 4;
        ig += comb((x - 1) * (y - 2), n) * 4;

        ig -= comb((x - 2) * (y - 2), n) * 6;
        return ig;
    }

    public static long comb(int a, int b) {
        if (a < b) {
            return 0;
        }
        long[] k = new long[a + 1];
        long[] pre = new long[a + 1];
        pre[0] = 1;
        for (int i = 0; i < a; i++) {
            k[0] = 1;
            for (int j = 1; pre[j - 1] != 0; j++) {
                k[j] = (pre[j] + pre[j - 1]) % LIM;
            }
            pre = k.clone();
        }
        return pre[b];
    }

    public static void main(String[] args) throws Exception {
        long S = System.currentTimeMillis();
        solve();
        long G = System.currentTimeMillis();
        System.out.println(G - S + "ms");
    }
}
