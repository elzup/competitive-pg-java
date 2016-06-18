package acm.domestic.y2005;

import java.util.*;

// dijkstra, bit dp, ticket,
public class QdHouseLoad {
    static int n, m, rn, s, g, ALL_B;

    static int[] tickets;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            n = sc.nextInt();
            m = sc.nextInt();
            rn = sc.nextInt();
            s = sc.nextInt() - 1;
            g = sc.nextInt() - 1;
            ALL_B = (1 << n);

            if ((n | m | rn | s + 1 | g + 1) == 0) {
                break;
            }

            @SuppressWarnings("unchecked")
            List<Edge>[] edges = new ArrayList[m];
            for (int i = 0; i < m; i++) {
                edges[i] = new ArrayList<>();
            }

            tickets = new int[n];
            for (int i = 0; i < n; i++) {
                tickets[i] = sc.nextInt();
            }
            for (int i = 0; i < rn; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                int z = sc.nextInt();
                edges[x].add(new Edge(y, z));
                edges[y].add(new Edge(x, z));
            }

            double[][] dp = new double[m][ALL_B];
            for (int i = 0; i < m; i++) {
                Arrays.fill(dp[i], Double.MAX_VALUE);
            }
            dp[s][ALL_B - 1] = 0;
            Queue<P> que = new PriorityQueue<>();
            que.add(new P(s, 0, ALL_B - 1));

            while (!que.isEmpty()) {
                P p = que.poll();
                List<Integer> is = p.ticket_index();
                for (Edge e : edges[p.v]) {
                    // // not use ticket
                    // if (dp[e.to][p.tickets] > dp[p.v][p.tickets] + e.cost) {
                    //     dp[e.to][p.tickets] = dp[p.v][p.tickets] + e.cost;
                    //     que.add(new P(e.to, dp[e.to][p.tickets], p.tickets));
                    // }

                    // use any ticket
                    for (int i : is) {
                        int at = p.tickets - (1 << i);
                        if (dp[e.to][at] > dp[p.v][p.tickets] + e.cost / tickets[i]) {
                            dp[e.to][at] = dp[p.v][p.tickets] + e.cost / tickets[i];
                            que.add(new P(e.to, dp[e.to][at], at));
                        }
                    }
                }
            }
            double min = Double.MAX_VALUE;
            for (int i = 0; i < ALL_B; i++) {
                min = Math.min(dp[g][i], min);
            }
            System.out.println((min == Double.MAX_VALUE) ? "Impossible" : min);
        }
    }

    static class Edge {
        public int to;
        public double cost;

        Edge(int to, double cost) {
            this.to = to;
            this.cost = cost;
        }

    }

    static class P implements Comparable<P> {
        public int v;
        public double cost;
        public int tickets;

        P(int v, double cost, int tickets) {
            this.v = v;
            this.cost = cost;
            this.tickets = tickets;
        }

        public List<Integer> ticket_index() {
            List<Integer> is = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (((this.tickets >> i) & 1) == 1) {
                    is.add(i);
                }
            }
            return is;
        }

        @Override
        public int compareTo(P o) {
            return (int) (this.cost - o.cost);
        }
    }
}
