package acm.domestic.y2017;

import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      if (n + m == 0) {
        break;
      }

      int max = Integer.MIN_VALUE;
      int a[] = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (i == j) {
            continue;
          }
          int r = a[i] + a[j];
          if (r <= m) {
            max = Math.max(max, r);
          }
        }
      }
      System.out.println(max == Integer.MIN_VALUE ? "NONE" : max);
    }
  }
}
