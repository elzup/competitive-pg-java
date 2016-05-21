package atcoder.arc.arc054;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 2000) {
            return;
        }

        Deque<ArrayList<Integer>> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            // System.out.println(k);
            if (k > 0) {
                ArrayList<Integer> e = new ArrayList<>();
                e.add(k);
                stack.push(e);
            } else if (k == 0) {
                ArrayList<Integer> e1 = stack.poll();
                ArrayList<Integer> e2 = stack.poll();
                e2.addAll(e1);
                stack.push(e2);
            } else {
                ArrayList<Integer> e = stack.poll();
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0; j < -k; j++) {
                    list.addAll(e);
                }
                stack.push(list);
            }
        }
        ArrayList<Integer> a = new ArrayList<>();

        for (ArrayList<Integer> e: stack) {
            for (int e2: e) {
                a.add(e2);
            }
        }

        int o = 0;
        int l = a.size();
        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j < l - 1; j++) {
                if (a.get(j) > a.get(j + 1)) {
                    int tmp = a.get(j);
                    a.set(j, a.get(j + 1));
                    a.set(j + 1, tmp);
                    o ++;
                }
            }
        }

        System.out.println(o);
    }
}
