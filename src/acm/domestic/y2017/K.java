package acm.domestic.y2017;

import java.util.Scanner;

public class K {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      if (x + y == 0) {
        break;
      }
      System.out.println((double)x / y);
    }
    System.out.println();
  }
}
