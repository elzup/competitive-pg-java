package atcoder.arc003;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        Node[][] nodes = new Node[h][w];
        Node startNode = null;
        Node goalNode = null;
        for (int i = 0; i < h; i++) {
            String line = sc.next();
            for (int j = 0; j < w ; j++) {
                char c = line.charAt(j);
                if (c == 's') {
                    nodes[i][j] = new Node(1000);
                    startNode = nodes[i][j];
                } else if (c == 'g') {
                    nodes[i][j] = new Node(1000);
                    goalNode = nodes[i][j];
                } else {
                    int p = Integer.valueOf(c + "");
                    nodes[i][j] = new Node(p);
                }
                if (i > 0) {
                    nodes[i][j].addBoth(nodes[i - 1][j]);
                }
                if (j > 0) {
                    nodes[i][j].addBoth(nodes[i][j - 1]);
                }
            }
        }
        // arrayDumpPoints(nodes);
        // arrayDumpLinks(nodes);
        ArrayList<Node> openNodes = new ArrayList<>();
        startNode.step = 1;
        openNodes.addAll(startNode.fire());
        // arrayDumpCost(nodes);
        while (true) {
            Node maxNode = openNodes.get(0);
            for (int i = 1; i < openNodes.size(); i++) {
                if (maxNode.cost < openNodes.get(i).cost) {
                    maxNode = openNodes.get(i);
                }
            }
            openNodes.remove(maxNode);
            openNodes.addAll(maxNode.fire());
            // arrayDumpCost(nodes);
            if (openNodes.contains(goalNode)) {
                break;
            }
        }
        System.out.println(goalNode.cost);
    }

    public static class Node {

        public static final int INIT = 0;
        public static final int OPEN = 1;
        public static final int CLOSE = 2;

        public ArrayList<Node> nodes;
        public double cost;
        public int step;
        public int status;
        public int point;
        public static long l;

        public Node(int point) {
            this.cost = Double.MAX_VALUE;
            this.point = point;
            this.nodes = new ArrayList<>();
            this.step = 0;
            this.status = INIT;
        }

        public void addBoth(Node node) {
            this.add(node);
            node.add(this);
        }

        public void add(Node node) {
            this.nodes.add(node);
        }

        public ArrayList<Node> fire() {
            ArrayList<Node> opened = new ArrayList<>();
            double opt = Math.pow(0.99f, step);
            for (Node node : this.nodes) {
                if (node.open(this.cost, opt, this.step)) {
                    opened.add(node);
                }
            }
            this.status = CLOSE;
            return opened;
        }

        public boolean open(double cost, double opt, int step) {
            if (this.status != INIT) {
                // System.out.println(this.cost + ":" + c);
                double newConst = Math.min(Math.min(cost, this.point * opt), this.cost);
                if (this.cost < newConst) {
                    this.cost = newConst;
                    this.step = step + 1;
                }
                return false;
            }
            if (cost == 0) {
                this.cost = this.point * opt;
            } else {
                this.cost = Math.min(cost, this.point * opt);
            }
            this.status = OPEN;
            this.step = step + 1;
            return true;
        }

        public void reset() {
            this.step = 0;
            this.status = INIT;
            this.cost = Double.MAX_VALUE;
        }
    }

    public static void arrayDumpCost(Node[][] k) {
        System.out.println("Cost");
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                if (k[i][j] == null) {
                    System.out.print("|  00.0000");
                    continue;
                }
                if (k[i][j].cost == Double.MAX_VALUE) {
                    System.out.print("|  --.----");
                    continue;
                }
                System.out.printf("|%04.4f", k[i][j].cost);
            }
            System.out.println();
        }
        System.out.println("---");
    }

    public static void arrayDumpPoints(Node[][] k) {
        System.out.println("Points");
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                System.out.printf("%2d", k[i][j].point);
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
