package acm.domestic.y2016_2;

import java.util.Arrays;
import java.util.Scanner;

public class A {
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
      Arrays.sort(a);
      int[] b = new int[n - 1];
      for (int i = 0; i < n - 1; i++) {
        b[i] = a[i + 1] - a[i];
      }
      Arrays.sort(b);
      System.out.println(b[0]);
    }
  }
}
