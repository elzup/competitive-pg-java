package atcoder.dp_typical;

import java.util.Scanner;

public class F {
  public static final long mod7 = 1000000007L;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    long[][] dp = new long[2][n + 1];
    dp[0][0] = 0;
    dp[0][1] = 1;
    dp[1][0] = 1;
    dp[1][1] = 1;
    for (int i = 1; i < k - 1; i++) {
      dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
      dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
    }
    // k - 1
    for (int i = k - 1; i < n; i++) {
      long pre = i - k < 0 ? 0 : dp[i - k];
      long pre2 = i - k - 1 < 0 ? 0 : dp[i - k - 1];
      dp[i] = 2 * dp[i - 1] - pre + pre2;
      System.out.println(i + "] " + dp[i]);
    }
    dp[n] = dp[n - 1] - dp[n - k];
    System.out.println("n - 1: " + dp[n - 1]);
    System.out.println("n - k: " + dp[n - k]);
    System.out.println(dp[n]);
  }
  // a ^ b (mod p)
  static long powMod(long a, long b, long p) {
    if (b == 0) {
      return 1;
    }
    if (b % 2 == 0) {
      long d = powMod(a, b / 2, p);
      return d * d % p;
    }
    return a * powMod(a, b - 1, p) % p;
  }
}
