package acm.domestic.y2017;

import java.util.HashMap;
import java.util.Scanner;

public class D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {

      int n = sc.nextInt();
      int m = sc.nextInt();
      if (n + m == 0) {
        break;
      }

      HashMap<String, Integer>[] maps = new HashMap[n + 2];
      String zero = strRepeat(m, "0");
      for (int i = 0; i <= n + 1; i++) {
        maps[i] = new HashMap<>();
      }
      maps[0].put(zero, 0);
      for (int i = 0; i < n; i++) {
        String line = sc.next();
        for (String key : maps[i].keySet()) {
          String res = bitFlip(line, key);
          int val = maps[i].get(key);
          // no create
          if (!maps[i + 1].containsKey(key)) {
            maps[i + 1].put(key, val);
          } else {
            maps[i + 1].put(key, Math.max(val, maps[i + 1].get(key)));
          }
          // create
          if (!maps[i + 1].containsKey(res)) {
            maps[i + 1].put(res, val + 1);
          } else {
            maps[i + 1].put(res, Math.max(maps[i + 1].get(res), val + 1));
          }
        }
      }
      System.out.println(maps[n].get(zero));
    }
  }

  static String strRepeat(int n, String str) {
    return new String(new char[n]).replace("\0", str);
  }

  static String bitFlip(String a, String b) {
    String k = "";
    for (int i = 0; i < a.length(); i++) {
      k += (a.charAt(i) == b.charAt(i)) ? "0" : "1";
    }
    return k;
  }
}
