package paiza.S002;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    static int M, N;
    final static int INF = Integer.MAX_VALUE;

    final static int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine();
        int sy = 0, sx = 0, ey = 0, ex = 0;
        Node[][] nodes = new Node[N][M];
        for (int i = 0; i < N; i++) {
            String[] vals = sc.nextLine().split(" ");
            for (int j = 0; j < M; j++) {
                String v = vals[j];
                if ("1".equals(v)) {
                    nodes[i][j] = null;
                    continue;
                }
                if ("s".equals(v)) {
                    sy = i;
                    sx = j;
                } else if ("g".equals(v)) {
                    ey = i;
                    ex = j;
                }
                nodes[i][j] = new Node();
                if (j > 0 && nodes[i][j - 1] != null) {
                    nodes[i][j].add(nodes[i][j - 1]);
                    nodes[i][j - 1].add(nodes[i][j]);
                }
                if (i > 0 && nodes[i - 1][j] != null) {
                    nodes[i][j].add(nodes[i - 1][j]);
                    nodes[i - 1][j].add(nodes[i][j]);
                }
            }
        }
        // arrayDump(nodes);
        nodes[sy][sx].setCost(0);
        nodes[sy][sx].check();
        if (nodes[ey][ex].isChecked) {
            System.out.println(nodes[ey][ex].cost);
        } else {
            System.out.println("Fail");
        }
    }

    public static class Node {
        public ArrayList<Node> nodes;
        public int cost = INF;
        public boolean isChecked = false;

        public Node() {
            this.nodes = new ArrayList<>();
        }
        public void add(Node node) {
            this.nodes.add(node);
        }
        public void check() {
            if (this.isChecked) {
                return;
            }
            this.isChecked = true;
            int min = INF;
            for (Node n: this.nodes) {
                min = Math.min(min, n.setCost(this.cost + 1));
            }
            for (Node n: this.nodes) {
                n.check();
            }
        }

        public int setCost(int cost) {
            // System.out.println(cost  + ":" + this.cost);
            return this.cost = Math.min(cost, this.cost);
        }
    }

    public static void arrayDump(Node[][] k) {
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                if (k[i][j] == null) {
                    System.out.print(" 0");
                    continue;
                }
                System.out.printf("%2d", k[i][j].nodes.size());
            }
            System.out.println();
        }
        System.out.println("---");
    }

}

