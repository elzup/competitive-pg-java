package acm.domestic.y2016_2;

import java.util.HashMap;
import java.util.Scanner;

public class B {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int n = sc.nextInt();
      if (n == 0) {
        break;
      }
      HashMap<String, Integer> map = new HashMap<>();
      sc.nextLine();
      String line = sc.nextLine();
      String[] cs = line.split(" ");
      for (int i = 0; i < n; i++) {
        String c = cs[i];
        if (!map.containsKey(c)) {
          map.put(c, 0);
        }
        map.put(c, map.get(c) + 1);
        int top1 = 0;
        int top2 = 0;
        String top1key = "";
        String top2key = "";
        for (String k : map.keySet()) {
          int v = map.get(k);
          if (top1 < v) {
            top2 = top1;
            top2key = top1key;
            top1 = v;
            top1key = k;
          } else if (top2 < v) {
            top2 = v;
            top2key = k;
          }
        }
        if (top1 == top2) {
          if (i == n - 1) {
            System.out.println("TIE");
          }
          continue;
        }
        if (top1 > top2 + (n - i - 1)) {
          System.out.println(top1key + " " + (i + 1));
          break;
        }
      }
    }
  }
}
