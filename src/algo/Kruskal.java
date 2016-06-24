package algo;

import java.util.Arrays;
import java.util.Scanner;

// Kruskal, group UnionFind
public class Kruskal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int w = sc.nextInt();
            edges[i] = new Edge(s, t, w);
        }
        Arrays.sort(edges);
        UnionFind uf = new UnionFind(V);
        int weight = 0;
        for (Edge e : edges) {
            if (!uf.equals(e.s, e.t)) {
                weight += e.w;
                uf.merge(e.s, e.t);
                if (uf.groups == 1) {
                    break;
                }
            }
        }
        System.out.println(weight);
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
            }
            if (rank[ra] < rank[rb]) {
                gid[ra] = rb;
            } else {
                gid[rb] = ra;
                if (rank[ra] == rank[rb]) {
                    rank[ra]++;
                }
            }
            return groups --;
        }
    }

    public static class Edge implements Comparable<Edge> {
        public int s, t, w;

        Edge(int s, int t, int w) {
            this.s = s;
            this.t = t;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
            // return o.w - this.w;
        }
    }
}
