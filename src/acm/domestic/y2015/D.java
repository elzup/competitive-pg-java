package acm.domestic.y2015;

import java.util.Scanner;

public class D {
  public static int INF = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      int n = sc.nextInt();
      if (n == 0) {
        break;
      }
      int l = 5000 * 100 + 1;
      int[][] v = new int[n + 1][l];
      int[][] o = new int[n + 1][l];
      for (int j = 0; j < n + 1; j++) {
        for (int i = 0; i < l; i++) {
          v[j][i] = -1;
          o[j][i] = -1;
        }
      }
      v[0][0] = 0;
      o[0][0] = 0;
      for (int j = 0; j < n + 1; j++) {
        for (int i = 0; i < l; i++) {
          if (v[j][i] == -1) {
            continue;
          }
        }
      }
    }
  }
}
