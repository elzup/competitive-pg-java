package acm.domestic.y2017;

import java.util.Scanner;

public class M {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int k = 247401;
    k ++;
    while (true) {
      int i = sc.nextInt();
      if (i == 0) {
        break;
      }
      System.out.println(i > k ? "larger" : "smaller");
    }
  }
}
