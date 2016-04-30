package atcoder.arc.arc052;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        HashMap<Integer, Double> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            double r = sc.nextInt();
            double h = sc.nextInt();
            double r2 = r * r * Math.PI;
            double b = 3 * h * h;
            for (int j = 1; j <= h; j++) {
                double t = r2 * (3 * j * j - 3 * j + 1) / b;
                // double rb = j * r / h;
                // double t1 = (rb * rb) * Math.PI * j;
                // double rb2 = (j - 1) * r / h;
                // double t2 = (rb2 * rb2) * Math.PI * (j - 1);
                // System.out.println(j + ": " + (t1 - t2) / 3);
                int xj = x - j;
                if (map.containsKey(xj)) {
                    map.put(xj, map.get(xj) + t);
                } else {
                    map.put(xj, t);
                }
            }
        }
        // for (Map.Entry<Integer, Double> e : map.entrySet()) {
        //     System.out.println(e.getKey() + ": " + e.getValue());
        // }
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            double s = 0;
            for (int j = a; j < b; j++) {
                if (map.containsKey(j)) {
                    s += map.get(j);
                }
            }
            System.out.println(s);
        }
    }
}
