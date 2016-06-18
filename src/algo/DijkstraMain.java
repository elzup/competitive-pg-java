package algo;

import java.util.*;

// dijkstra ダイクストラ
public class DijkstraMain {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vn = sc.nextInt();
        int ve = sc.nextInt();
        int s = sc.nextInt();

        Dijkstra dkr = new Dijkstra(vn, ve);

        for (int i = 0; i < ve; i++) {
            dkr.set(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        dkr.run(s);

        for (int i = 0; i < vn; i++) {
            System.out.println(dkr.d[i] == INF ? "INF" : dkr.d[i]);
        }
    }

    static class Dijkstra {
        int vn, en;
        int[] d;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] edges;

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
