package atcoder.arc041;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class Qc {

    static InputStream is;
    static PrintWriter out;
    static String INPUT = "";

    final int INF = Integer.MAX_VALUE;
    final int MIN = Integer.MIN_VALUE;
    public static int L;

    static void solve() {
        int n = ni();
        L = ni();
        boolean preIsRight = true;
        ArrayList<Group> groups = new ArrayList<>();
        Group g = new Group(L);
        for (int i = 0; i < n; i++) {
            int x = ni();
            String d = ns();
            boolean isRight = "R".equals(d);
            // System.out.println(isRight);

            if (isRight && !preIsRight) {
                groups.add(g);
                g = new Group(L);
            }
            if (isRight) {
                g.leftPos.add(x - 1);
            } else {
                g.rightPos.add(x - 1);
            }
            preIsRight = isRight;
        }
        groups.add(g);
        long sum = 0;
        for (Group gi: groups) {
            System.out.println(gi);
            long k = gi.calc();
            System.out.println(k);
            sum += k;
        }
        System.out.println(sum);
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

class Group {
    public ArrayList<Integer> leftPos;
    public ArrayList<Integer> rightPos;

    public static int end;

    public Group(int end) {
        this.end = end;
        this.leftPos = new ArrayList<>();
        this.rightPos = new ArrayList<>();
    }

    public long calc() {
        int start = -1;
        int end = this.end;

        // if (this.leftPos.size() != 0 && this.rightPos.size() != 0) {
        //     int preStart = leftPos.get(leftPos.size());
        //     int preEnd = rightPos.get(0);
        // }
        long sum = 0;
        if (this.leftPos.size() > 0) {
            sum += calcLeft();
            start = leftPos.get(leftPos.size() - 1);
        }
        if (this.rightPos.size() > 0) {
            sum += calcRight();
            end = rightPos.get(0);
        }
        end -= 1;

        long ds = (end - start) * Math.max(leftPos.size(), rightPos.size());
        sum += ds;
        // System.out.println("ds " + ds);
        return sum;
    }

    public long calcLeft() {
        long e = leftPos.get(leftPos.size() - 1);
        long sum = 0;
        for (int i = 0, l = this.leftPos.size() - 1; i < l; i++) {
            long d = e - leftPos.get(i) - (l - i);
            sum += d;
        }
        // System.out.println("l  " + sum);
        return sum;
    }

    public long calcRight() {
        int s = rightPos.get(0);
        long sum = 0;
        for (int i = 1, l = this.rightPos.size(); i < l; i++) {
            long d = rightPos.get(i) - (s + i);
            sum += d;
            System.out.println("ld " + i + ":" + d);
        }
        System.out.println("r  " + sum);
        return sum;
    }

    @Override
    public String toString() {
        String str = "g {";
        for (Integer p : leftPos) {
            str += p + " ";
        }
        str += " - ";
        for (Integer p : rightPos) {
            str += p + " ";
        }
        str += "}";
        return str;
    }
}
