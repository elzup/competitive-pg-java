package algo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class Dijkstra {

    // ダイクストラ
    static InputStream is;
    static PrintWriter out;
    static String INPUT = "";

    final static int INF = Integer.MAX_VALUE;
    final static int MIN = Integer.MIN_VALUE;

    static void solve() {
        int V = ni();
        int E = ni();
        int r = ni();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < E; i++) {
            int s = ni();
            int t = ni();
            int d = ni();
            ArrayList<Edge> list = graph.get(s);
            list.add(new Edge(t, d));
        }

        PriorityQueue<Node> pQue = new PriorityQueue<Node>(10, COMPARATOR);

        int[] d = new int[V];
        Arrays.fill(d, INF);
        d[r] = 0;
        pQue.add(new Node(r, 0));

        while (!pQue.isEmpty()) {
            Node node = pQue.poll();
            int now = node.id;
            if (d[now] < node.d) {
                continue;
            }
            ArrayList<Edge> list = graph.get(now);
            for (int i = 0; i < list.size(); i++) {
                Edge edge = list.get(i);
                if (d[edge.to] > d[now] + edge.cost) {
                    d[edge.to] = d[now] + edge.cost;
                    pQue.add(new Node(edge.to, d[edge.to]));
                }
            }
        }

        for (int i : d) {
            System.out.println(i == INF ? "INF" : i);
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
        // System.out.println(Arrays.deepToString(o));
    }

    public static final Comparator<Node> COMPARATOR = new Comp();

    private static class Comp implements Comparator<Node>{
        public int compare(Node x,Node y){
            return (x.d > y.d) ? 1 : ((x.d == y.d) ? 0 : -1);
        }
    }

    static class Node {
        int id;
        int d;
        Node(int id,int d){
            this.id = id;
            this.d = d;
        }
    }

    static class Edge {
        int to;
        int cost;
        Edge(int to,int cost){
            this.to = to;
            this.cost = cost;
        }
    }

}
