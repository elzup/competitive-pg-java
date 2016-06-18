package algo;

import java.util.*;

public class PrimMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        Prim prim = new Prim(V, E);

        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int w = sc.nextInt();
            prim.set(s, t, w);
            prim.set(t, s, w);
        }

        int res = prim.run();
        System.out.println(res);
    }

    public static class Prim {
        int V, E;
        ArrayList<Edge>[] edges;

        @SuppressWarnings("unchecked")
        Prim(int V, int E) {
            this.V = V;
            this.E = E;
            edges = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                edges[i] = new ArrayList<>();
            }
        }

        void set(int from, int to, int cost) {
            edges[from].add(new Edge(to, cost));
        }

        int run() {
            boolean[] done = new boolean[V];
            Arrays.fill(done, false);
            Queue<Edge> q = new PriorityQueue<>();
            q.add(new Edge(0, 0));
            int costSum = 0;
            while (!q.isEmpty()) {
                Edge e = q.poll();
                if (done[e.t]) {
                    continue;
                }
                done[e.t] = true;
                costSum += e.w;
                q.addAll(edges[e.t]);
            }
            return costSum;
        }

    }

    public static class Edge implements Comparable<Edge> {
        public int t, w;

        Edge(int t, int w) {
            this.t = t;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}

