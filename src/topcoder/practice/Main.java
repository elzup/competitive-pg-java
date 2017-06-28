package topcoder.practice;

import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    System.out.println(createString(3, 2));
    System.out.println(createString(2, 0));
    System.out.println(createString(5, 8));
    System.out.println(createString(10, 12));
  }

  public static String createString(int n, int k) {
    if (k == 0) {
      return String.join("", Collections.nCopies(n - 1, "B")) + "A";
    }
    int t1 = k;
    int t2 = k;
    for (int i = 2; i <= k; i++) {
      if (k % i == 0) {
        t1 = k / i;
        t2 = k / t1;
        if (t2 + t1 <= n) {
          break;
        }
      }
      if (i == k - 1) {
        return "";
      }
    }
    System.out.println(n);
    System.out.println(t1);
    System.out.println(t2);
    String suffix = String.join("", Collections.nCopies(n - t1 - t2, "A"));
    String a = String.join("", Collections.nCopies(t1, "A"));
    String b = String.join("", Collections.nCopies(t2, "B"));
    return suffix + a + b;
  }
}
