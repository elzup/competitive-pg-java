package atcoder.tenka1.y2016;

import java.util.ArrayList;
import java.util.Scanner;

public class Qb {
    static ArrayList<Node> nodes;
    static Node root;
    static int N, M;
    static int t;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        root = new Node(0);
        N = sc.nextInt();
        M = sc.nextInt();
        nodes = new ArrayList<>();
        nodes.add(root);
        for (int i = 0; i < N - 1; i++) {
            int parent = sc.nextInt();
            Node node = new Node(parent);
            nodes.add(node);
            nodes.get(parent).childrens.add(node);
        }
        for (int i = 0; i < M; i++) {
            int ni = sc.nextInt();
            int nv = sc.nextInt();
//            System.out.println(ni + ", " + nv);
            nodes.get(ni).value = nv;
        }
        root.calcMin();
        root.min = 0;
        root.calcV(0);
        System.out.println(t);
    }

    public static class Node {
        public ArrayList<Node> childrens;
        public int parent;
        public int value;
        public int min;

        Node(int parent) {
            this.parent = parent;
            this.childrens = new ArrayList<>();
            this.min = 0;
        }

        public int calcMin() {
            if (this.childrens.size() == 0) {
                return this.value;
            }
            min = Integer.MAX_VALUE;
            for (Node node : childrens) {
                int v = node.calcMin();
                min = Math.min(v, min);
            }
            return min;
        }

        public void calcV(int v) {
            if (this.childrens.size() == 0) {
//                System.out.println(this.value + ", " + v + ", " + (this.value - v));
                t += Math.max(0, this.value - v);
                return;
            }
            for (Node node : childrens) {
                node.calcV(this.min);
            }
//            System.out.println(v + "," + this.min + "," + (this.min - v));
            t += this.min - v;
        }
    }
}
