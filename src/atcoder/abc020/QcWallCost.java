package atcoder.abc020;

import java.util.ArrayList;
import java.util.Scanner;

public class QcWallCost {
    final static int INF = Integer.MAX_VALUE;
    public static Node[][] nodes;
    public static int sx, sy, ex, ey, h, w;
    public static long t;

    // astar a star エースター
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        t = sc.nextLong();

        nodes = new Node[h][w];
        sx = 0;
        sy = 0;
        ex = 0;
        ey = 0;

        sc.nextLine();
        for (int i = 0; i < h; i++) {
            String vals = sc.nextLine();
            for (int j = 0; j < w; j++) {
                char c = vals.charAt(j);
                if (c == 'S') {
                    sy = i;
                    sx = j;
                } else if (c == 'G') {
                    ey = i;
                    ex = j;
                }
                nodes[i][j] = new Node('#' == c);
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
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (nodes[i][j] != null) {
                    nodes[i][j].span = (Math.abs(i - ey) + Math.abs(j - ex));
                }
            }
        }
        long maxT = t;
        long minT = 0;
        long l = t;
        while (true) {
            long res = cost(l);
            // System.out.println(">" + l);
            // arrayDumpCost(nodes);
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    nodes[i][j].reset();
                }
            }
            // System.out.println(res + ":" + t);
            if (res <= t) {
                minT = l;
            } else {
                maxT = l;
            }
            // System.out.println("mint: " + minT);
            // System.out.println("maxt: " + maxT);
            if (maxT - minT <= 1) {
                break;
            }
            l  = (minT + maxT) / 2;
        }
        System.out.println(minT);
    }

    public static long cost(long l) {
        Node.l = l;
        ArrayList<Node> opens = new ArrayList<>();
        Node p = nodes[sy][sx];
        opens.add(p);
        p.open(-1);
        while (true) {
            opens.remove(p);
            opens.addAll(p.fire());
            if (opens.size() == 0) {
                break;
            }
            long max = Long.MAX_VALUE;
            for (Node o : opens) {
                if (o.weight() < max) {
                    p = o;
                    max = o.weight();
                }
            }
            if (p.span == 0) {
                break;
            }
        }
        return nodes[ey][ex].cost;
    }

    public static class Node {
        public static final int INIT = 0;
        public static final int OPEN = 1;
        public static final int CLOSE = 2;

        public ArrayList<Node> nodes;
        public long cost;
        public int span;
        public int status;
        public boolean isWall;
        public static long l;

        public long weight() {
            return this.cost + this.span;
        }

        public Node(boolean isWall) {
            this.cost = Long.MAX_VALUE;
            this.isWall = isWall;
            this.nodes = new ArrayList<>();
            this.status = INIT;
        }

        public void add(Node node) {
            this.nodes.add(node);
        }

        public ArrayList<Node> fire() {
            ArrayList<Node> opened = new ArrayList<>();
            for (Node node : this.nodes) {
                if (node.open(this.cost)) {
                    opened.add(node);
                }
            }
            this.status = CLOSE;
            return opened;
        }

        public boolean open(long c) {
            if (this.status != INIT) {
                // System.out.println(this.cost + ":" + c);
                this.cost = Math.min(this.cost, c + dCost());
                return false;
            }
            this.cost = c + this.dCost();
            this.status = OPEN;
            return true;
        }

        public long dCost() {
            return this.isWall ? l : 1;
        }

        public void reset() {
            this.status = INIT;
            this.cost = INF;
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
                if (k[i][j].cost == INF) {
                    System.out.print("   -");
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
