package atcoder.atc.atc001;

import java.util.ArrayList;
import java.util.Scanner;

public class DeepthFirstSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        sc.nextLine();

        Node startNode = null;
        Node[][] nodes = new Node[h][w];
        for (int i = 0; i < h; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < w; j++) {
                char c = line.charAt(j);
                if (c == '#') {
                    continue;
                }
                Node n = new Node();
                nodes[i][j] = n;
                if (c == 'g') {
                    n.setGoal();
                }
                if (c == 's') {
                    startNode = n;
                }
                if (i > 0 && nodes[i - 1][j] != null) {
                    nodes[i - 1][j].add(n);
                    n.add(nodes[i - 1][j]);
                }
                if (j > 0 && nodes[i][j - 1] != null) {
                    nodes[i][j - 1].add(n);
                    n.add(nodes[i][j - 1]);
                }
            }
        }
        assert startNode != null;
        System.out.println(startNode.fire() ? "Yes" : "No");
    }


    public static class Node {
        public static final int INIT = 0;
        public static final int CLOSE = 2;

        public ArrayList<Node> nodes;
        public int status;
        public boolean goal = false;

        public Node() {
            this.nodes = new ArrayList<>();
            this.status = INIT;
        }

        public void setGoal() {
            this.goal = true;
        }

        public void add(Node node) {
            this.nodes.add(node);
        }

        public boolean fire() {
            if (this.goal) {
                return true;
            }
            if (this.status == CLOSE) {
                return false;
            }
            this.status = CLOSE;
            for (Node n : this.nodes) {
                if (n.fire()) {
                    return true;
                }
            }
            return false;
        }
    }
}

