package atcoder.abc.abc005;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = sc.nextInt();
            }
        }
        int q = sc.nextInt();
        int[] p = new int[q];
        for (int i = 0; i < q; i++) {
            p[i] = sc.nextInt();
        }
        int[][] d_sum = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i | j) == 0) {
                    d_sum[0][0] = d[i][j];
                } else if (i == 0) {
                    d_sum[i][j] = d[i][j] + d_sum[i][j - 1];
                } else if (j == 0) {
                    d_sum[i][j] = d[i][j] + d_sum[i - 1][j];
                } else {
                    d_sum[i][j] = d[i][j] + d_sum[i - 1][j] + d_sum[i][j - 1] - d_sum[i - 1][j - 1];
                }
            }
        }
        // arrayDump(d);
        // arrayDump(d_sum);
        int[] max = new int[n * n + 1];
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                int[][] d_max = new int[n - x + 1][n - y + 1];
                for (int i = 0; i < n - x + 1; i ++) {
                    for (int j = 0; j < n - y + 1; j ++) {
                        int t = d_sum[i + x - 1][j + y - 1];
                        if (i > 0) {
                            t -= d_sum[i - 1][j + y - 1];
                        }
                        if (j > 0) {
                            t -= d_sum[i + x - 1][j - 1];
                        }
                        if (i > 0 && j > 0){
                            t += d_sum[i - 1][j - 1];
                        }
                        max[x * y] = Math.max(max[x * y], t);
                        d_max[i][j] = t;
                    }
                }
                // System.out.println("max" + x * y + ": " + max[x * y]);
                // arrayDump(d_max);
                // System.out.println();
            }
        }
        // for (int i = 0; i <= n * n; i++) {
        //     System.out.println(i + ": " + max[i]);
        // }
        for (int i = 2; i <= n * n; i++) {
            max[i] = Math.max(max[i], max[i - 1]);
        }
        // for (int i = 0; i <= n * n; i++) {
        //     System.out.println(i + ": " + max[i]);
        // }
        for (int i = 0; i < q; i++) {
            System.out.println(max[Math.min(p[i], n * n)]);
        }
    }

    public static void arrayDump(int[][] k) {
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                System.out.print(k[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---");
    }
}
