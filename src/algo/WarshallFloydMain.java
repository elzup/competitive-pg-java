package algo;

import java.util.Arrays;
import java.util.Scanner;

// ワーシャルフロイド wf
public class WarshallFloydMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int en = sc.nextInt();

        WarshallFloyd wf = new WarshallFloyd();
        wf.init(n);
        for (int i = 0; i < en; i++) {
            wf.set(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        wf.run();

        // negative loop check
        if (wf.hasNegativeLoop()) {
            System.out.println("NEGATIVE CYCLE");
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(wf.d[i][j]);
            }
        }
    }

    static class WarshallFloyd {
        int n;
        int d[][];
        static final int INF = Integer.MAX_VALUE;

        public void init(int n) {
            int[][] d = new int[n][n];
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
                if (d[i][i] < 0) {
                    return true;
                }
            }
            return false;
        }
    }
}

