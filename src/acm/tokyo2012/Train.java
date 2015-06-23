package acm.tokyo2012;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public class Train {
    static InputStream is;
    static PrintWriter out;
    static String INPUT = "";

    final static int INF = Integer.MAX_VALUE;
    final static int MAXDIS = 100000;

    static void solve() {
        while (true) {
            int n = ni(), m = ni(), c = ni(), s = ni() - 1, g = ni() - 1;
            if ((n | m | c | s | g) == 0) {
                break;
            }
            int[][] mlist = new int[m][4];
            int [][][] dispass = new int [c][n][n];
            for (int i = 0; i < c; i++) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(dispass[i][j], INF);
                    dispass[i][j][j] = 0;
                }
            }
            for (int i = 0; i < m; i++) {
                int from = ni() - 1, to = ni() - 1, dis = ni(), nowc = ni() - 1;
                mlist[i][0] = from;
                mlist[i][0] = to;
                mlist[i][0] = dis;
                mlist[i][0] = nowc;
                if (dispass[nowc][to][from] > dis) {
                    dispass[nowc][to][from] = dis;
                    dispass[nowc][from][to] = dis;
                }
            }
            for (int cind = 0; cind < c; cind++) {
                for (int j = 0; j < n; j++) {
                    for (int i = 0; i < n; i++) {
                        for (int k = 0; k < n; k++) {
                            dispass[cind][i][k] = Math.min(dispass[cind][i][k], dispass[cind][i][j] + dispass[cind][j][k]);
                        }
                    }
                }
            }

            int[] plist = new int[c];
            for (int i = 0; i < c; i++) {
                plist[i] = ni();
            }

            ArrayList<ArrayList<Integer>> qlist = new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Integer>> rlist = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < c; i++) {
                qlist.add(new ArrayList<Integer>());
                qlist.get(i).add(0);
                rlist.add(new ArrayList<Integer>());
                for (int j = 0; j < plist[i] - 1; j++) {
                    qlist.get(i).add(ni());
                }
                qlist.get(i).add(MAXDIS);
                for (int j = 0; j < plist[i]; j++) {
                    rlist.get(i).add(ni());
                }
            }

            int[][] farelist = new int[c][MAXDIS + 1];
            for (int cInd = 0; cInd < c; cInd++) {
                ArrayList<Integer> nowq = qlist.get(cInd);
                for (int i = 1; i < nowq.size(); i++) {
                    for (int j = nowq.get(i - 1) + 1; j <= nowq.get(i); j++) {
                        farelist[cInd][j] = farelist[cInd][j - 1] + rlist.get(cInd).get(i - 1);
                    }
                }
            }
            int [][] pass = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = INF;
                    for (int cind = 0; cind < c; cind++) {
                        int dis = dispass[cind][i][j];
                        if (dis >= INF) continue;
                        value = Math.min(value, farelist[cind][dis]);
                    }
                    pass[i][j] = value;
                }
            }

            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    for (int k = 0; k < n; k++) {
                        pass[i][k] = Math.min(pass[i][k], pass[i][j] + pass[j][k]);
                    }
                }
            }

            int ans = pass[s][g] >= INF ? -1 : pass[s][g];
            System.out.println(ans);
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
