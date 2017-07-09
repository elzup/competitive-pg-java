package acm.domestic.y2010;

import java.util.Scanner;

public class QcBorock {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] dp = new int[1000000 + 1];
    int[] dp2 = new int[1000000 + 1];
    for (int i = 1; i < dp.length; i++) {
      dp[i] = i;
      dp2[i] = i;
    }
    for (int i = 1; ; i++) {
      int k = (i * (i + 1) * (i + 2)) / 6;
      if (k >= 1000000) {
        break;
      }
      for (int j = 0; j + k < 1000000; j++) {
        dp[j + k] = Math.min(dp[j + k], dp[j] + 1);
      }
      if (k % 2 == 1) {
        for (int j = 0; j + k < 1000000; j++) {
          dp2[j + k] = Math.min(dp2[j + k], dp2[j] + 1);
        }
      }
    }

    while (true) {
      int n = sc.nextInt();
      if (n == 0) {
        break;
      }
      System.out.println(dp[n] + " " + dp2[n]);
    }
  }
}
