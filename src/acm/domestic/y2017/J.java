package acm.domestic.y2017;

import java.util.Scanner;

public class J {
  public static void main(String[] args) {
    int max = Integer.MIN_VALUE;
    Scanner sc = new Scanner(System.in);

    while (true) {
      int a = sc.nextInt();
      if (a == 0) {
        break;
      }
      max = Math.max(a, max);
    }
    System.out.println(max);
  }
}
