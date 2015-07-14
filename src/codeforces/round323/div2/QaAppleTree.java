package codeforces.round323.div2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.in;
import static java.util.Arrays.copyOf;
import static java.util.Arrays.deepToString;

public class QaAppleTree {

    static InputStream is;
    static PrintWriter out;
    static String INPUT = "";

    final int INF = MAX_VALUE;
    final int MIN = MIN_VALUE;

    static void solve() {
        int n = ni();
        ArrayList<Tree> trees1 = new ArrayList<>();
        ArrayList<Tree> trees2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Tree t = new Tree();
            t.x = ni();
            t.p = ni();
            if (t.x > 0) {
                trees1.add(t);
            } else {
                trees2.add(t);
            }
        }
        Collections.sort(trees1, (a, b) -> a.x > b.x ? 1 : -1);
        Collections.sort(trees2, (a, b) -> a.x < b.x ? 1 : -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = 0, b = 0;
            if (i < trees1.size()) {
                a = trees1.get(i).p;
            }
            if (i < trees2.size()) {
                b = trees2.get(i).p;
            }
            sum += a + b;
            if (a == 0 || b == 0) {
                break;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        long S = currentTimeMillis();
        is = INPUT.isEmpty() ? in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
        long G = currentTimeMillis();
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
        return parseDouble(ns());
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
        return n == p ? buf : copyOf(buf, p);
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
        if (INPUT.length() != 0) System.out.println(deepToString(o));
    }
}

class Tree {
    public int x;
    public int p;
}
