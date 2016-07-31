package atcoder.tenka1.y2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> rules = new ArrayList<>();
        WarshallFloyd wf = new WarshallFloyd();
        wf.init(26);

        for (int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();
            if (a.length() > b.length() && a.substring(0, b.length()).equals(b)) {
                System.out.println(-1);
                return;
            }
            int ml = Math.min(a.length(), b.length());
            for (int j = 0; j < ml; j++) {
                char ac = a.charAt(j);
                char bc = b.charAt(j);
                wf.set(ac - 97, bc - 97, -1);
                if (ac != bc) {
                    rules.add(bc + "" + ac);
                    break;
                }
            }
        }

        for (String r : rules) {
            System.out.println(r);
        }

        wf.run();
        if (wf.hasNegativeLoop()) {
            System.out.println(-10);
            return;
        }

        String lib = "abcdefghijklmnopqrstuvexyz";
    }

    static class WarshallFloyd {
        int n;
        int d[][];
        static final int INF = Integer.MAX_VALUE;

        public void init(int n) {
            d = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(d[i], INF);
                d[i][i] = 0;
            }
            this.n = n;
        }

        void run() {
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    if (d[i][k] == INF)
                        continue;
                    for (int j = 0; j < n; j++) {
                        if (d[k][j] != INF) {
                            d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                        }
                    }
                }
            }
        }

        void set(int from, int to, int cost) {
            d[from][to] = cost;
            d[to][from] = cost;
        }

        boolean hasNegativeLoop() {
            for (int i = 0; i < d.length; i++) {
                System.out.println(d[i][i]);
                if (d[i][i] < 0) {
                    return true;
                }
            }
            return false;
        }
    }


}
