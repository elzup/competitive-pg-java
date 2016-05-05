package atcoder.abc.abc035;

import java.util.*;

public class QdTreasure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(sc.nextInt()));
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();
            Node na = nodes.get(a);
            Node nb = nodes.get(b);
            na.addLink(nb, c);
            nb.addRevLink(na, c);
        }

        ArrayList<Node> openNodes = new ArrayList<>();
        Node first = nodes.get(0);
        openNodes.add(first);
        first.cost = 0;
        first.revCost = 0;
        while (!openNodes.isEmpty()) {
            Node minNode = openNodes.get(0);
            for (Node node: openNodes) {
                if (node != minNode && minNode.cost < node.cost) {
                    minNode = node;
                }
            }
            minNode.open();
            for (Node node: minNode.links.keySet()) {
                if (!openNodes.contains(node) && !node.isOpen) {
                    openNodes.add(node);
                }
            }
            openNodes.remove(minNode);
        }

        nodes.forEach(Node::reset);

        openNodes = new ArrayList<>();
        openNodes.add(first);
        while (!openNodes.isEmpty()) {
            Node minNode = openNodes.get(0);
            for (Node node: openNodes) {
                if (node != minNode && minNode.revCost < node.revCost) {
                    minNode = node;
                }
            }
            minNode.revOpen();
            for (Node node: minNode.revLinks.keySet()) {
                if (!openNodes.contains(node) && !node.isOpen) {
                    openNodes.add(node);
                }
            }
            openNodes.remove(minNode);
        }

        long maxPoint = 0;
        for (Node node: nodes) {
            long k = t - node.cost - node.revCost;
            if (k < 0) {
                continue;
            }
            maxPoint = Math.max(maxPoint, k * node.value);
        }
        System.out.println(maxPoint);
    }

    // dijkstra ダイクストラ 有向グラフ
    public static class Node {
        public long value;
        public HashMap<Node, Integer> links;
        public HashMap<Node, Integer> revLinks;
        public long cost;
        public long revCost;
        public boolean isOpen;

        Node(int value) {
            this.value = value;
            this.cost = Long.MAX_VALUE;
            this.revCost = Long.MAX_VALUE;
            this.links = new HashMap<>();
            this.revLinks = new HashMap<>();
            this.isOpen = false;
        }

        public void addLink(Node n, int cost) {
            this.links.put(n, cost);
        }

        public void addRevLink(Node n, int cost) {
            this.revLinks.put(n, cost);
        }

        public void reset() {
            this.isOpen = false;
        }

        public void open() {
            this.isOpen = true;
            for (Map.Entry<Node, Integer> e: this.links.entrySet()){
                long cost = e.getValue();
                Node node = e.getKey();
                node.cost = Math.min(node.cost, this.cost + cost);
            }
        }

        public void revOpen() {
            this.isOpen = true;
            for (Map.Entry<Node, Integer> e: this.revLinks.entrySet()){
                long cost = e.getValue();
                Node node = e.getKey();
                node.revCost = Math.min(node.revCost, this.revCost + cost);
            }
        }
    }
}
