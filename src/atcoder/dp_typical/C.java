package atcoder.dp_typical;

import java.util.Scanner;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();
    int n = 1 << k;
    int[] r = new int[n];
    for (int i = 0; i < n; i++) {
      r[i] = sc.nextInt();
    }
    double[][] vsmap = new double[n][n];
    double[][] dp = new double[n][k + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        vsmap[i][j] = vs(r[i], r[j]);
      }
      dp[i][0] = 1;
    }
    for (int i = 0; i < k; i++) {
      int t = 2 << i;
//      System.out.println(":" + t);
      for (int j = 0; j < n / t; j++) {
        int le = j * t;
        int ri = (j + 1) * t - 1;
//        System.out.println(le + ", " + ri);
        for (int l = le; l <= ri; l++) {
          int le2 = l - le < t / 2 ? le + t / 2 : le;
          int ri2 = l - le < t / 2 ? ri : le + t / 2 - 1;
          double s = 0;
          for (int l2 = le2; l2 <= ri2; l2++) {
            s += dp[l2][i] * vsmap[l][l2];
//            System.out.println(dp[l2][i] + " * " + vsmap[l][l2]);
//            System.out.println(l + "_" + l2);
          }
          dp[l][i + 1] = dp[l][i] * s;
        }
//        System.out.println();
      }
//      System.out.println();
    }
    for (int i = 0; i < n; i++) {
      System.out.printf("%.8f\n", dp[i][k]);
    }
  }

  static double vs(double r1, double r2) {
    double t = 1 + Math.pow(10, (r2 - r1) / 400);
    return 1.0f / t;
  }
}

