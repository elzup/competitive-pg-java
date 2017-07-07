package atcoder.dp_typical;

import java.util.Scanner;

public class D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int d = sc.nextInt();

    double[][] t = new double[n + 1][720];
    t[0][1] = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < 720; j++) {
        if (t[i][j] == 0) {
          continue;
        }
        for (int k = 1; k <= 6; k++) {
          int nj = k * j % 720;
          t[i + 1][nj] += t[i][j] / 6.0;
//          System.out.printf(" %.3f", t[i + 1][nj]);
        }
//        System.out.println();
      }
    }
    double sum = 0;
    for (int i = 0; i < 720; i += d) {
      sum += t[n][i];
    }
//    System.out.println(t[n][d]);
    System.out.println(sum);
  }

}
