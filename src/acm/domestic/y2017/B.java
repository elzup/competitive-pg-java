package acm.domestic.y2017;

import java.util.Scanner;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      String a = sc.next();
      if (".".equals(a)) {
        break;
      }
      String b = sc.next();
      a = a.replaceAll("\"", "\"EMPTYCLASH");
      b = b.replaceAll("\"", "\"EMPTYCLASH");
      String[] as = a.split("\"");
      String[] bs = b.split("\"");
      if (as.length != bs.length) {
        System.out.println("DIFFERENT");
        continue;
      }
      boolean ok = true;
      for (int i = 0; i < as.length; i += 2) {
        if (!as[i].equals(bs[i])) {
          ok = false;
          break;
        }
      }
      if (!ok) {
        System.out.println("DIFFERENT");
        continue;
      }
      int c = 0;
      for (int i = 1; i < bs.length; i += 2) {
        if (!as[i].equals(bs[i])) {
          c++;
        }
      }
      if (c == 0) {
        System.out.println("IDENTICAL");
      } else if (c == 1) {
        System.out.println("CLOSE");
      } else {
        System.out.println("DIFFERENT");
      }
    }
  }

}
