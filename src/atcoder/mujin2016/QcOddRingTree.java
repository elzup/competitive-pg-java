package atcoder.mujin2016;

import java.util.ArrayList;
import java.util.Scanner;

public class QcOddRingTree {

    public static int k;
    public static ArrayList<String> actives;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] routes = new int[m][2];
        // ArrayList<Node> nodes = new ArrayList<>();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            routes[i][0] = x;
            routes[i][1] = y;
        }

        int l = 1 << n - 1;
        int c = 0;
        ArrayList<Integer> cs = new ArrayList<>();
        ArrayList<Integer> bi = new ArrayList<>();
        for (k = 0; k < l; k++) {
            // System.out.println(k);
            actives = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if (((k >> j) & 1) == 1) {
                    actives.add(routes[j][0] + " " + routes[j][1]);
                }
            }
            if (actives.size() <= 2) {
                c ++;
                cs.add(k);
                bi.add(Integer.bitCount(k));
                continue;
            }
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nodes[j].die = false;
                }
                if (!nodes[i].check(0, i)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                c ++;
                cs.add(k);
                bi.add(Integer.bitCount(k));
            }
        }

        ArrayList<Integer> deplicates = new ArrayList<>();
        for (int i = 0; i < cs.size(); i++) {
            for (int j = 0; j < cs.size(); j++) {
                if (bi.get(i) > bi.get(j)) {
                    // System.out.println(cs.get(i) + " | " + cs.get(j) + " -> " + (cs.get(i) | cs.get(j)));
                    if ((cs.get(i) | cs.get(j)) == cs.get(i)) {
                        if (!deplicates.contains(cs.get(j))) {
                            // System.out.println("__ " + j);
                            deplicates.add(cs.get(j));
                        }
                    }
                }
            }
        }
        System.out.println(cs.size() - deplicates.size());
    }

    public static boolean isActive(int a, int b) {
        return actives.contains(a + " " + b);
    }

    public static class Node {

        public ArrayList<Node> children;
        public boolean die;
        public int id;

        public Node(int id) {
            this.children = new ArrayList<>();
            this.id = id;
            this.die = false;
        }

        public void addNode(Node n) {
            this.children.add(n);
        }

        public boolean check(int rank, int start) {
            if (this.die) {
                return ((start != this.id) || (rank % 2 == 0));
            }
            this.die = true;
            for (Node n : children) {
                if (isActive(this.id, n.id) && !n.check(rank + 1, start)) {
                    return false;
                }
            }
            return true;
        }
    }
}
