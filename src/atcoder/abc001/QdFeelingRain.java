package atcoder.abc001;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public class QdFeelingRain {

    static InputStream is;
    static PrintWriter out;
    static String INPUT = "";

    final int INF = Integer.MAX_VALUE;
    final int MIN = Integer.MIN_VALUE;

    static void solve() {
        int n = ni();

        ArrayList<Term> terms = new ArrayList<>();
        int[][] res = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] se = ns().split("-");
            int s = round5(new Integer(se[0]), false);
            int e = round5(new Integer(se[1]), true);
            System.out.println("s: " + s);
            System.out.println("e: " + e);

            ArrayList<Term> mergedTerms = new ArrayList<>();
            for (Term t : terms) {
                if (t.insert(s, e)) {
                    mergedTerms.add(t);
                }
            }
            if (mergedTerms.size() == 0) {
                terms.add(new Term(s, e));
            } else {
                while (mergedTerms.size() > 1) {
                    ArrayList<Term> mergedTerms2 = new ArrayList<>();
                    for (Term t : mergedTerms) {
                        for (Term t2 : mergedTerms) {
                            if (t == t2) {
                                continue;
                            }
                            if (t.insert(t2)) {
                                mergedTerms2.add(t2);
                            }
                        }
                    }
                    mergedTerms.removeAll(mergedTerms2);
                    terms.removeAll(mergedTerms2);
                }
            }
        }
        for (Term t: terms) {
            System.out.println(t);
        }
    }

    public static int round5(int n, boolean toAfter) {
        if (toAfter) {
            return n + (5 - n % 5) % 5;
        }
        return n - n % 5;
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

class Term {
    public int s;
    public int e;

    public Term(int s, int e) {
        this.s = s;
        this.e = e;
    }

    public boolean insert(int ns, int ne) {
        if (this.in(ns)) {
            this.e = Math.max(this.e, ne);
            return true;
        } else if (this.in(ne)) {
            this.s = Math.min(this.s, ns);
            return true;
        } else if (ns < this.s && this.e < ne) {
            this.s = ns;
            this.e = ne;
        }
        return false;
    }

    public boolean insert(Term t) {
        return this.insert(t.s, t.e);
    }

    public boolean in(int n) {
        return in(n, this.s, this.e);
    }

    public static boolean in(int n, int min, int max) {
        return min <= n && n <= max;
    }

    @Override
    public String toString() {
        return String.format("%04d-%04d", this.s, this.e);
    }
}
