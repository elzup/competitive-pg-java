package codeiq.weelky;

import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] xs = new int[2][10];
        String[] nss = sc.next().split(",");
        for (int i = 0; i < 10; i++) {
            xs[0][i] = Integer.parseInt(nss[i]);
        }
        nss = sc.next().split(",");
        for (int i = 0; i < 10; i++) {
            xs[1][i] = Integer.parseInt(nss[i]);
        }
        int[][] m = new int[10][10];
        Dijkstra dstr = new Dijkstra(100, 180);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                m[i][j] = xs[0][i] + xs[1][j];
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i < 9) {
                    dstr.set(i * 10 + j, (i + 1) * 10 + j, m[i + 1][j]);
                }
                if (j < 9) {
                    dstr.set(i * 10 + j, i * 10 + j + 1, m[i][j + 1]);
                }
            }
        }
        dstr.run(0);
        System.out.println(m[0][0] + dstr.d[99]);
    }

    static class Dijkstra {
        int vn, en;
        int[] d;

        ArrayList<Edge>[] edges;

        @SuppressWarnings("unchecked")
        Dijkstra(int vn, int en) {
            this.vn = vn;
            this.en = en;
            edges = new ArrayList[vn];
            for (int i = 0; i < vn; i++) {
                edges[i] = new ArrayList<>();
            }
        }

        void run(int start) {
            d = new int[vn];
            Arrays.fill(d, INF);
            d[start] = 0;

            Queue<Edge> queue = new PriorityQueue<>();
            queue.add(new Edge(start, 0));

            while (!queue.isEmpty()) {
                Edge e1 = queue.poll();
                if (d[e1.target] < e1.cost) {
                    continue;
                }

                for (Edge e2 : edges[e1.target]) {
                    if (d[e2.target] > d[e1.target] + e2.cost) {
                        d[e2.target] = d[e1.target] + e2.cost;
                        queue.add(new Edge(e2.target, d[e2.target]));
                    }
                }
            }
        }

        void set(int from, int to, int cost) {
            this.edges[from].add(new Edge(to, cost));
            this.edges[to].add(new Edge(from, cost));
        }
    }

    static class Edge implements Comparable<Edge> {
        int target;
        int cost;

        public Edge(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
