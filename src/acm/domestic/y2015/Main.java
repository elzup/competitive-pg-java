package acm.domestic.y2015;

import com.sun.xml.internal.xsom.XSWildcard;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Edge[] edges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            if ((n | m | k) == 0) {
                break;
            }

            edges = new Edge[m];
            for (int i = 0; i < m; i++) {
                int f = sc.nextInt() - 1;
                int t = sc.nextInt() - 1;
                int c = sc.nextInt();
                String com = sc.next();
                edges[i] = new Edge(f, t, c, com.equals("A") ? 1 : 0);
            }
            double l = -100;
            double r = 100;
            int realWeight = 0;
            double p = 0.000001;
            UnionFind uf = new UnionFind(0);
            while (r - l > p) {
                double a = (r + l) / 2;
                for (Edge e : edges) {
                    if (e.com == 1) {
                        e.reset(a);
                    }
                }
                uf = new UnionFind(n);
                Arrays.sort(edges);
                int kc = 0;
                realWeight = 0;
                for (Edge e : edges) {
                    if (uf.equals(e.from, e.to)) {
                        continue;
                    }
                    realWeight += e.baseCost;
                    if (e.com == 1) {
                        kc++;
                    }
                    uf.merge(e.from, e.to);
                    if (uf.groups == 1) {
                        break;
                    }
                }
                System.out.println(k + "," + kc + ":" + a);
                if (k == kc) {
                    break;
                } else if (k > kc) {
                    r = a - p;
                } else {
                    l = a + p;
                }
            }
            if (uf.groups > 1) {
                System.out.println(-1);
            } else {
                System.out.println(realWeight);
            }
        }
    }

    static class UnionFind {
        int[] gid, rank;
        int groups;

        UnionFind(int n) {
            gid = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                gid[i] = i;
                rank[i] = 0;
            }
            groups = n;
        }

        int find(int a) {
            if (gid[a] == a) {
                return a;
            }
            return gid[a] = find(gid[a]);
        }

        boolean equals(int a, int b) {
            return find(a) == find(b);
        }

        int merge(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if (ra == rb) {
                return groups;
            } else {
                gid[rb] = ra;
                if (rank[ra] == rank[rb]) {
                    rank[ra]++;
                }
            }
            return groups--;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to, com, baseCost;
        double cost;

        Edge(int from, int to, int cost, int com) {
            this.from = from;
            this.to = to;
            this.cost = this.baseCost = cost;
            this.com = com;
        }

        public void reset(double k) {
            this.cost = this.baseCost + k;
        }

        @Override
        public int compareTo(Edge o) {
            return (int) (this.cost - o.cost);
        }
    }
}
