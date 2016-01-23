package paiza.S002;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int M, N;
    final static int INF = -1;

    final static int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // a star a* エースター
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
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (nodes[i][j] != null) {
                    nodes[i][j].setSpan(Math.abs(i - ey) + Math.abs(j - ex));
                }
            }
        }

        ArrayList<Node> opens = new ArrayList<>();
        Node p = nodes[sy][sx];
        p.cost = 0;
        while (true) {
            opens.remove(p);
            opens.addAll(p.fire());
            if (opens.isEmpty()) {
                break;
            }
            p = opens.get(0);
            int w = p.weight();
            for (Node n : opens) {
                if (w > n.weight()) {
                    p = n;
                }
            }
            if (p.span == 0) {
                break;
            }
        }
        // arrayDumpSpan(nodes);
        // arrayDumpCost(nodes);
        // arrayDumpWeight(nodes);
        if (nodes[ey][ex].status == Node.INIT) {
            System.out.println("Fail");
        } else {
            System.out.println(nodes[ey][ex].cost);
        }
    }

    public static class Node {
        public static final int INIT = 0;
        public static final int OPEN = 1;
        public static final int CLOSE = 2;

        public ArrayList<Node> nodes;
        public int cost = INF;
        public int span;
        public int status;

        public int weight() {
            return this.cost + this.span;
        }

        public Node() {
            this.nodes = new ArrayList<>();
            this.status = INIT;
        }

        public void setSpan(int span) {
            this.span = span;
        }


        public void add(Node node) {
            this.nodes.add(node);
        }

        public ArrayList<Node> fire() {
            ArrayList<Node> opened = new ArrayList<>();
            for (Node node: this.nodes) {
                if (node.open(this.cost + 1)) {
                    opened.add(node);
                }
            }
            this.status = CLOSE;
            return opened;
        }

        public boolean open(int c) {
            if (this.status != INIT) {
                // System.out.println(this.cost + ":" + c);
                this.cost = Math.min(this.cost, c);
                return false;
            }
            this.cost = c;
            this.status = OPEN;
            return true;
        }
    }

    public static void arrayDumpSpan(Node[][] k) {
        System.out.println("Span");
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                if (k[i][j] == null) {
                    System.out.print("   0");
                    continue;
                }
                System.out.printf("%4d", k[i][j].span);
            }
            System.out.println();
        }
        System.out.println("---");
    }

    public static void arrayDumpCost(Node[][] k) {
        System.out.println("Cost");
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                if (k[i][j] == null) {
                    System.out.print("   0");
                    continue;
                }
                System.out.printf("%4d", k[i][j].cost);
            }
            System.out.println();
        }
        System.out.println("---");
    }

    public static void arrayDumpWeight(Node[][] k) {
        System.out.println("Weight");
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                if (k[i][j] == null) {
                    System.out.print("   0");
                    continue;
                }
                System.out.printf("%4d", k[i][j].weight());
            }
            System.out.println();
        }
        System.out.println("---");
    }

    public static void arrayDumpLinks(Node[][] k) {
        System.out.println("Links");
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                if (k[i][j] == null) {
                    System.out.print("   0");
                    continue;
                }
                System.out.printf("%4d", k[i][j].nodes.size());
            }
            System.out.println();
        }
        System.out.println("---");
    }

}

