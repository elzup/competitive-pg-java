package atcoder.abc.abc038;

import java.util.*;

public class Main {
    static ArrayList<Box> boxs;
    static HashMap<Box, Integer> memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boxs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            boxs.add(new Box(h, w));
        }
        for (int i = 0; i < n - 1; i++) {
            Queue<Box> queue = new ArrayDeque<>();
            queue.addAll(boxs);
            Box b1 = boxs.get(i);
            // queue.removeAll(b1.parents);
            // queue.removeAll(b1.children);
            // while (!queue.isEmpty()) {
            //     Box b2 = queue.poll();
            //     switch (b1.compareTo(b2)) {
            //         case 1:
            //             b1.children.add(b2);
            //             b1.children.addAll(b2.children);
            //             b2.parents.add(b1);
            //             // b2.parents.addAll(b1.parents);
            //             queue.removeAll(b2.children);
            //             break;
            //         case -1:
            //             b1.parents.add(b2);
            //             b1.parents.addAll(b2.parents);
            //             b2.children.add(b1);
            //             // b2.children.addAll(b1.children);
            //             queue.removeAll(b2.parents);
            //             break;
            //     }
            // }
            for (int j = i + 1; j < n; j++) {
                Box b2 = boxs.get(j);
                switch (b1.compareTo(b2)) {
                    case 1:
                        b1.children.add(b2);
                        b2.parents.add(b1);
                        break;
                    case -1:
                        b2.children.add(b1);
                        b1.parents.add(b2);
                        break;
                }
            }
        }

        memo = new HashMap<>();

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, inBoxCount(boxs.get(i)));
        }
        System.out.println(max);
    }

    public static int inBoxCount(Box box) {
        if (memo.containsKey(box)) {
            return memo.get(box);
        }
        int c = 0;
        for (Box b: box.children) {
            c = Math.max(c, inBoxCount(b));
        }
        memo.put(box, c + 1);
        return c + 1;
    }

    public static class Box implements Comparable {
        ArrayList<Box> children, parents;
        int h, w;
        Box(int h, int w) {
            this.h = h;
            this.w = w;
            this.parents = new ArrayList<>();
            this.children = new ArrayList<>();
        }

        @Override
        public int compareTo(Object o) {
            Box ob = (Box) o;
            if (ob.w > this.w && ob.h > this.h) {
                return -1;
            }
            if (this.w > ob.w && this.h > ob.h) {
                return 1;
            }
            return 0;
        }
    }
}
