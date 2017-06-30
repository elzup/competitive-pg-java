package acm.domestic.y2015_2;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int m = sc.nextInt();
      if (m == 0) {
        break;
      }
      int min = sc.nextInt();
      int max = sc.nextInt();
      int[] p = new int[m];
      for (int i = 0; i < m; i++) {
        p[i] = sc.nextInt();
      }
      solve(m, min, max, p);
    }
  }
  public static void solve(int m, int min, int max, int[] p) {
    int diff = 0;
    int si = 0;
    for (int i = min - 1; i < max; i++) {
      int d = p[i] - p[i + 1];
      if (diff <= d) {
        si = i;
        diff = d;
      }
    }
    System.out.println(si + 1);
  }
}
