package atcoder.abc.abc003;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class QcRate {

    static InputStream is;
    static PrintWriter out;
    static String INPUT = "";

    final int INF = Integer.MAX_VALUE;
    final int MIN = Integer.MIN_VALUE;

    static void solve() {
        int N = ni();
        int K = ni();

        int[] ps = new int[N];

        for (int k = 0; k < N; k++) {
            ps[k] = ni();
        }
        Arrays.sort(ps);

        double[][] dp = new double[N + 1][K + 1];
        for (int i = 0, l = dp.length; i < l; i++) {
             for (int j = 0, l2 = dp[0].length; j < l2; j++) {
                 dp[i][j] = -1;
             }
         }
        dp[0][0] = 0;

        double max = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                if (1 <= j) {
                    if (dp[i - 1][j] == -1 && dp[i - 1][j - 1] == -1) {
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i - 1][j], ((dp[i - 1][j - 1] + ps[i - 1]) / 2));
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                if (j == K) {
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        // arrayDump(dp);
        System.out.println(max);
    }

    public static void arrayDump(double[][] k) {
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                System.out.print(String.format("%5.2f ", k[i][j]));
            }
            System.out.println();
        }
        System.out.println("---");
    }

    public static void main(String[] args) throws Exception {
        long S = System.currentTimeMillis();
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
        long G = System.currentTimeMillis();
        tr(G - S + "ms");
    }

    private static boolean eof() {
        if (lenbuf == -1) return true;
        int lptr = ptrbuf;
        while (lptr < lenbuf) if (!isSpaceChar(inbuf[lptr++])) return false;

        try {
            is.mark(1000);
            while (true) {
                int b = is.read();
                if (b == -1) {
                    is.reset();
                    return true;
                } else if (!isSpaceChar(b)) {
                    is.reset();
                    return false;
                }
            }
        } catch (IOException e) {
            return true;
        }
    }

    private static byte[] inbuf = new byte[1024];
    static int lenbuf = 0, ptrbuf = 0;

    private static int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private static boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    //	private static boolean isSpaceChar(int c) { return !(c >= 32 && c <= 126); }
    private static int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b)) ;
        return b;
    }

    private static double nd() {
        return Double.parseDouble(ns());
    }

    private static char nc() {
        return (char) skip();
    }

    private static String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private static char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private static char[][] nm(int n, int m) {
        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = ns(m);
        return map;
    }

    private static int[] na(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }

    private static int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private static long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }

        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private static void tr(Object... o) {
        if (INPUT.length() != 0) System.out.println(Arrays.deepToString(o));
    }
}
