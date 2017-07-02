package atcoder.abc.abc066;

import java.util.Scanner;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int i;
    for (i = s.length() - 2; i > 0; i -= 2) {
//      System.out.println(i);
      String a = s.substring(0, i / 2);
      String b = s.substring(i / 2, i);
//      System.out.println(a);
//      System.out.println(b);
      if (a.equals(b)) {
        break;
      }
    }
    System.out.println(i);
  }
}
