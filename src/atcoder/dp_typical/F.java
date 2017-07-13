package atcoder.dp_typical;

import java.util.Scanner;

public class F {
  public static final long mod7 = 1000000007L;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    long[] dp = new long[n + 2];
    long[] sum = new long[n + 3];
    dp[0] = 1;
    sum[1] = 1;
    for (int i = 1; i <= n + 1; i++) {
      if (i != 1 && i != n) {
        dp[i] = (sum[i] - sum[(int) Math.max(i - k, 0L)] + mod7) % mod7;
      }
      sum[i + 1] += dp[i] + sum[i];
      sum[i + 1] %= mod7;
    }
//    for (int i = 0; i < dp.length; i++) {
//      System.out.printf("%4d", dp[i]);
//    }
    System.out.println();
    System.out.println(dp[n + 1]);
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
