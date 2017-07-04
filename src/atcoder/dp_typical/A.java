package atcoder.dp_typical;

import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int max = n * 100;
    boolean[][] dp = new boolean[n + 1][max + 1];
    dp[0][0] = true;
    for (int i = 1; i <= n; i++) {
      int p = sc.nextInt();
      for (int j = 0; j < max; j++) {
        if (!dp[i - 1][j]) {
          continue;
        }
        dp[i][j] = true;
        if (j + p <= max) {
          dp[i][j + p] = true;
        }
      }
    }
    int c = 0;
    for (int i = 0; i <= max; i++) {
      if (dp[n][i]) {
        c++;
      }
    }
    System.out.println(c);
  }
}
