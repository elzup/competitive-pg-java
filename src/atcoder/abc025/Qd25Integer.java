package atcoder.abc025;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Qd25Integer {

    static InputStream is;
    static PrintWriter out;
    static String INPUT = "";

    final int INF = Integer.MAX_VALUE;
    final int MIN = Integer.MIN_VALUE;

    static void solve() {
        int[][] map = new int[5][5];
        int emp = 0;
        boolean[] ic = new boolean[25];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = ni();
                if (map[i][j] == 0) {
                    emp++;
                } else {
                    ic[map[i][j] - 1] = true;
                }
            }
        }
        if (emp > 8) {
            System.out.println("> うまるーん <");
            return;
        }

        int[] leasts = new int[emp];
        for (int i = 0, li = 0; i < 25; i++) {
            if (!ic[i]) {
                leasts[li++] = i;
            }
        }
        int p = 1;
        for (int i = 2; i <= emp; i++) {
            p *= i;
        }

        // arrayDump(new int[][]{leasts});

        id = 0;
        int[][] res = new int[p][emp];
        make_perm(0, new int[emp], new boolean[emp + 1], res);
        int count = 0;

        for (int i = 0; i < p; i++) {
            int[][] map2 = arrayCopy(map);
            int resi = 0;
            // arrayDump(new int[][] {res[i]});
            for (int ki = 0; ki < 5; ki++) {
                for (int kj = 0; kj < 5; kj++) {
                    if (map2[ki][kj] == 0) {
                        map2[ki][kj] = leasts[res[i][resi] - 1] + 1;
                        resi++;
                    }
                }
            }
            // arrayDump(map2);
            if (check(map2)) {
                count++;
            }
        }
        System.out.println(count);
    }
    static int id;

    static boolean check(int[][] map) {
        boolean check = true;
        for (int i = 0; i < 5 && check; i++) {
            for (int j = 0; j < 5 && check; j++) {
                if (i < 3) {
                    check &= !(map[i][j] < map[i + 1][j] && map[i + 1][j] < map[i + 2][j]);
                    check &= !(map[i][j] > map[i + 1][j] && map[i + 1][j] > map[i + 2][j]);
                }
                if (j < 3) {
                    check &= !(map[i][j] < map[i][j + 1] && map[i][j + 1] < map[i][j + 2]);
                    check &= !(map[i][j] > map[i][j + 1] && map[i][j + 1] > map[i][j + 2]);
                }
            }
        }
        return check;
    }

    public static int[][] arrayCopy(int[][] k) {
        int[][] k2 = new int[k.length][k[0].length];
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                k2[i][j] = k[i][j];
            }
        }
        return k2;
    }

    public static void arrayDump(int[][] k) {
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                System.out.print(k[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---");
    }

    static int permId = 0;
    static void make_perm(int n, int[] perm, boolean[] flag, int[][] res) {
        if (n == perm.length) {
            res[permId++] = perm.clone();
        } else {
            for (int i = 1; i <= perm.length; i++) {
                if (flag[i]) continue;
                perm[n] = i;
                flag[i] = true;
                make_perm(n + 1, perm, flag, res);
                flag[i] = false;
            }
        }
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
