package acm.domestic.y2016;

import java.util.Scanner;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {

      int m = sc.nextInt();
      int n = sc.nextInt();
      if ((m | n) == 0) {
        break;
      }
      int c = 0;

      boolean[] ck = new boolean[7368792];
      int i = m - 1;
      while (i < 7368791) {
        i++;
        if (ck[i]) {
          continue;
        }
        if (c >= n) {
          break;
        }
        c++;
        for (int j = i; j < 7368792; j += i) {
          ck[j] = true;
        }
      }
      System.out.println(i);
    }
  }
}
