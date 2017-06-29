package atcoder.dp_typical;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    int l = s.length();
    for (int w = 0; w < l; w += 3) {
      for (int i = 0; i + w <= l; i++) {
        System.out.println(s.substring(i, i + w));
        if (s.substring(i, i + w) == "iwi") {

        }
      }
      System.out.println();
    }
  }
}
