package atcoder.agc.agc016;

import java.util.Scanner;

public class QaSurbal {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int mi = 200;
    for (char i = 'a'; i <= 'z'; i++) {
      int m = 0;
      String[] ws = s.split("" + i);
      for (String w : ws) {
        m = Math.max(m, w.length());
      }
      mi = Math.min(m, mi);
    }
    System.out.println(mi);
  }
}
