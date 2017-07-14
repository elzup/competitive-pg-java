package acm.domestic.y2017;

import java.util.Scanner;

public class L {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < n; i++) {
      String s = sc.nextLine();
      System.out.println(s.length());
    }
  }
}
