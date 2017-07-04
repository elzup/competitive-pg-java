package atcoder.dp_typical;

import java.util.Scanner;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int an = sc.nextInt();
    int bn = sc.nextInt();
    int[] a = new int[an];
    int[] b = new int[bn];
    for (int i = 0; i < an; i++) {
      a[i] = sc.nextInt();
    }
    for (int i = 0; i < bn; i++) {
      b[i] = sc.nextInt();
    }
    int[][] sum = new int[an + 1][bn + 1];
    for (int i = 0; i < sum.length; i++) {
      if (i > 0) {
        sum[i][0] = sum[i - 1][0] + a[an - i];
      }
      for (int j = 0; j < sum[i].length; j++) {
        if (j > 0) {
          sum[i][j] = sum[i][j - 1] + b[bn - j];
        }
      }
    }

//    System.out.println("--------");
//    for (int i = 0; i < sum.length; ++i) {
//      for (int j = 0; j < sum[i].length; ++j) {
//        System.out.printf(" %2d", sum[i][j]);
//      }
//      System.out.println();
//    }


    int[][] dp = new int[an + 1][bn + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        if (i > 0 && j > 0) {
          dp[i][j] = Math.max(sum[i][j] - dp[i - 1][j], sum[i][j] - dp[i][j - 1]);
        } else if (i > 0) {
          dp[i][j] = sum[i][j] - dp[i - 1][j];
        } else if (j > 0) {
          dp[i][j] = sum[i][j] - dp[i][j - 1];
        }
      }
    }

//    System.out.println("--------");
//    for (int i = 0; i < dp.length; ++i) {
//      for (int j = 0; j < dp[i].length; ++j) {
//        System.out.printf(" %2d", dp[i][j]);
//      }
//      System.out.println();
//    }
    System.out.println(dp[an][bn]);
  }
}
