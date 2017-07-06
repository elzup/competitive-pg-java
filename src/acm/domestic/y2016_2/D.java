package acm.domestic.y2016_2;

import java.util.Scanner;

public class D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int n = sc.nextInt();
      if (n == 0) {
        break;
      }
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      boolean[][] dp = new boolean[n][n];
      int w;
      for (w = 2; w <= n; w += 2) {
        boolean any = false;
        for (int l = 0; l + w - 1 < n; l++) {
          if (w == 2) {
            dp[l][l + 1] = Math.abs(a[l] - a[l + 1]) <= 1;
            any = any || dp[l][l + 1];
//            System.out.printf("%3s", dp[l][l + 1] ? "1" : "0");
            continue;
          }
          int r = l + w;
          if (w == 4) {
            dp[l][r - 1] = (dp[l][l + 1] && dp[r - 2][r - 1])
                    || (dp[l + 1][r - 2] && Math.abs(a[l] - a[r - 1]) <= 1);
          } else {
            dp[l][r - 1] = (dp[l][r - 3] && dp[r - 2][r - 1])
                    || (dp[l][l + 1] && dp[l + 2][r - 1])
                    || (dp[l + 1][r - 2] && Math.abs(a[l] - a[r - 1]) <= 1);
          }
          // 0, 1, 2, 3, 4, 5, 6, 7
//          System.out.printf("%3s", dp[l][r - 1] ? "1" : "0");
          any = any || dp[l][r - 1];
        }
//        System.out.println();
        if (!any) {
          break;
        }
      }
      int[][] dp2 = new int[n][n];
      for (int i = 0; i < n - 1; i++) {
        dp2[i][i + 1] = dp[i][i + 1] ? 2 : 0;
//        System.out.printf("%3d", dp2[i][i + 1]);
      }
//      System.out.println();

      for (w = 4; w <= n; w += 2) {
        for (int l = 0; l + w - 1 < n; l++) {
          int r = l + w - 1;
          if (dp[l][r]) {
            dp2[l][r] = w;
          } else {
            for (int d = l + 2; d <= r - 1; d += 2) {
              dp2[l][r] = Math.max(dp2[l][r], dp2[l][d - 1] + dp2[d][r]);
            }
          }
//          System.out.printf("%3d", dp2[l][r]);
        }
//        System.out.println();
      }
      if (n % 2 == 1) {
        System.out.println(Math.max(dp2[0][n - 2], dp2[1][n - 1]));
      } else {
        System.out.println(dp2[0][n - 1]);
      }
    }
  }
}
