package acm.domestic_pre.y2017;

import java.util.Scanner;

public class D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (solve(sc)) {
    }
  }

  public static boolean solve(Scanner sc) {
    int n = sc.nextInt();
    int m = sc.nextInt();
    if ((n | m) == 0) {
      return false;
    }
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    int l = 1;
    int r = 1000000;
    int p = r / 2;
    int bn;
    while (true) {
      bn = 0;
//      System.out.println("p: " + p);
      int lv = 1;
      for (int i = 1; i < n; i++) {
        if (a[i] < lv + p) {
          continue;
        }
        while (a[i] >= lv + p) {
          lv += Math.max(1, p - Math.abs(a[i - 1] - lv));
          bn++;
//          System.out.println(lv);
        }
      }
      if (r - l <= 1) {
        p = bn > m ? r : l;
        break;
      }
      if (bn > m) {
        l = p;
      } else {
        r = p;
      }
      p = l + (r - l) / 2;
    }
    // System.out.println("l: " + l);
    // System.out.println("r: " + r);
    // System.out.println(bn);
    if (r <= 2 && bn < m){
      System.out.println(-1);
    } else{
      System.out.println(p);
    }
    return true;
  }
}
