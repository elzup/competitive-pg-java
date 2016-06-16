package algo;

class UnionFind {
    int[] gid, rank;

    UnionFind(int n) {
        gid = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            gid[i] = i;
            rank[i] = 0;
        }
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

    void merge(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) { return; }
        if (rank[ra] < rank[rb]) {
            gid[ra] = rb;
        } else {
            gid[rb] = ra;
            if (rank[ra] == rank[rb]) {
                rank[ra] ++;
            }
        }
    }
}
