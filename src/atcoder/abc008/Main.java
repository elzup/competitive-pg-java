package atcoder.abc008;

import java.util.*;

public class Main {
    public static int w, h, n;
    public static int[][] points;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt();
        h = sc.nextInt();
        n = sc.nextInt();
        if (w > 80 || h > 80 || n > 8) {
            System.out.println("\\(^o^)/");
        }
        points = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
        }
        combs(new ArrayList<>(), 0, new int[][]{});
        System.out.println();
    }

    public static void combs(ArrayList<Integer> cs, int k, int[][] m) {
        if (k == cs.size()) {
            m[m.length] = cs.stream().mapToInt(i -> i).toArray();
            return;
        }
        for (int i = 0, l = cs.size(); i < l; i++) {
            if (cs.contains(l)) {
                continue;
            }
            cs.add(i);
            combs(cs, k + 1, m);
            cs.remove(cs.size() - 1);
        }
    }

}
