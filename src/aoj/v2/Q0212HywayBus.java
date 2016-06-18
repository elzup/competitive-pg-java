package aoj.v2;

import java.util.*;

// dp, ticket
public class Q0212HywayBus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int c = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            if ((c | n | m | s | d) == 0) {
                break;
            }
            s--;
            d--;

            @SuppressWarnings("unchecked")
            List<Edge>[] edges = new ArrayList[n];
            for (int i = 0; i < edges.length; i++) {
                edges[i] = new ArrayList<>();
            }
            int[][] dp = new int[n][c + 1];
            for (int[] dpp : dp) {
                Arrays.fill(dpp, Integer.MAX_VALUE >> 1);
            }
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                int f = sc.nextInt();
                edges[a].add(new Edge(b, f));
                edges[b].add(new Edge(a, f));
            }
            PriorityQueue<P> queue = new PriorityQueue<>();
            dp[s][c] = 0;
            queue.add(new P(s, c, 0));
            while (!queue.isEmpty()) {
                P p = queue.poll();
                for (Edge e : edges[p.v]) {
                    if (dp[e.to][p.c] > dp[p.v][p.c] + e.cost) {
                        dp[e.to][p.c] = dp[p.v][p.c] + e.cost;
                        queue.add(new P(e.to, p.c, dp[e.to][p.c]));
                    }
                    if (p.c > 0 && dp[e.to][p.c - 1] > dp[p.v][p.c] + e.cost / 2) {
                        dp[e.to][p.c - 1] = dp[p.v][p.c] + e.cost / 2;
                        queue.add(new P(e.to, p.c - 1, dp[e.to][p.c - 1]));
                    }
                }
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i <= c; i++) {
                if (dp[d][i] == Integer.MAX_VALUE >> 1) {
                    continue;
                }
                res = Math.min(res, dp[d][i]);
            }
            System.out.println(res);
        }
    }

    static class Edge {
        public int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class P implements  Comparable<P> {
        int v;
        int cost;
        int c;

        P(int v, int c, int cost) {
            this.v = v;
            this.cost = cost;
            this.c = c;
        }

        @Override
        public int compareTo(P o) {
            return this.cost - o.cost;
        }
    }
}
