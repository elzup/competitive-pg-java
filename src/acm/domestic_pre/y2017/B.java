package acm.domestic_pre.y2017;

import java.util.Scanner;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int t = sc.nextInt();
      int d = sc.nextInt();
      int l = sc.nextInt();
      if (t == 0) {
        break;
      }
      int dd = 0;
      int k = 0;
      for (int i = 0; i < t; i++) {
        int x = sc.nextInt();
        if (x > l) {
          dd = d + 2;
        }
        dd = Math.max(0, dd - 1);
        System.out.println(dd);
        if (dd > 0) {
          k++;
        }
      }
      System.out.println(k);
      System.out.println();
    }
  }
}
