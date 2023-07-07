package acm.domestic.y2023;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            int[] x = new int[n * n];
            for (int i = 0; i < n * n; i++) {
              x[i] = sc.nextInt();
            }
            solve(n, x);
        }

    }

    private static void solve(int n, int[] x) {
        int[][] res = new int[n][n];

        for (int i = 0; i < n * n; i++) {
            int tv = i / 2 + (i % 2 == 0 ? 0 : 1) * ((n * n + 1) / 2);
//            System.out.println(i + "," + tv + ",");
            res[tv / n][tv % n] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(x[res[i][j]] + (j == n - 1 ? "\n" : " "));
            }
        }
    }
}
