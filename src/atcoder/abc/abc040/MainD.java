package atcoder.abc.abc040;

import java.util.Arrays;
import java.util.Scanner;

public class MainD {
    static int N, M, Q;
    // static short[][] memos;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();


        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int y = sc.nextInt();
            edges[i] = new Edge(a, b, y);
        }

        Q = sc.nextInt();

        if (M > 2000 || N > 1000 || Q > 1000) {
            return;
        }

        Arrays.sort(edges);
        // memos = new short[N][200001];
        // for (int i = 0; i < N; i++) {
        //     Arrays.fill(memos[i], (short) -1);
        //     memos[i][200000] = 0;
        // }
        // // int i = 200000;
        // UnionFind uf = new UnionFind(N);
        // for (Edge e : edges) {
        //     uf.merge(e.source, e.target);
        //     // for (; i > e.year; i--) {
        //     for (int j = 0; j < N; j++) {
        //         memos[j][e.year - 1] = uf.size(j);
        //     }
        //     // }
        //     // System.out.println(e.year);
        // }

        for (int j = 0; j < Q; j++) {
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();
            // System.out.println(v + ": " + w);
            UnionFind uf = new UnionFind(N);
            for (Edge e : edges) {
                if (e.year <= w) {
                    break;
                }
                uf.merge(e.source, e.target);
            }
            System.out.println(uf.size(v));
        }
    }

    static class UnionFind {
        int[] gid, rank;
        short[] size;

        UnionFind(int n) {
            gid = new int[n];
            size = new short[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                gid[i] = i;
                rank[i] = 0;
                size[i] = 1;
            }
        }

        int find(int a) {
            if (gid[a] == a) {
                return a;
            }
            return gid[a] = find(gid[a]);
        }

        short size(int a) {
            return size[find(a)];
        }

        boolean equals(int a, int b) {
            return find(a) == find(b);
        }

        void merge(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if (ra == rb) {
                return;
            }
            size[ra] = size[rb] = (short) (size[ra] + size[rb]);
            if (rank[ra] < rank[rb]) {
                gid[ra] = rb;
            } else {
                gid[rb] = ra;
                if (rank[ra] == rank[rb]) {
                    rank[ra]++;
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int source;
        int target;
        int year;

        public Edge(int source, int target, int cost) {
            this.source = source;
            this.target = target;
            this.year = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return o.year - this.year;
        }
    }
}
