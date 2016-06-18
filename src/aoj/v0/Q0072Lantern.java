package aoj.v0;

import java.util.*;

// prim
public class Q0072Lantern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int V = sc.nextInt();
            if (V == 0) {
                break;
            }
            int E = sc.nextInt();
            Prim prim = new Prim(V, E);

            for (int i = 0; i < E; i++) {
                String line = sc.next();
                String[] data = line.split(",");
                int s = Integer.valueOf(data[0]);
                int t = Integer.valueOf(data[1]);
                int w = Integer.valueOf(data[2]) / 100 - 1;
                prim.set(s, t, w);
                prim.set(t, s, w);
            }

            int res = prim.run();
            System.out.println(res);
        }
    }

    private static class Prim {
        int V, E;
        ArrayList<ArrayList<Edge>> edges;

        Prim(int V, int E) {
            this.V = V;
            this.E = E;
            edges = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                edges.add(new ArrayList<>());
            }
        }

        void set(int from, int to, int cost) {
            edges.get(from).add(new Edge(to, cost));
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
                q.addAll(edges.get(e.t));
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
