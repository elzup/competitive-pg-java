package acm.domestic_pre.y2017;

import java.util.HashMap;
import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      if ((n | m) == 0) {
        break;
      }
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int i = 1; i <= m; i++) {
        map.put(i, 0);
      }
      for (int i = 0; i < n; i++) {
        int d = sc.nextInt();
        int v = sc.nextInt();
        map.put(d, Math.max(map.get(d), v));
      }
      int sum = 0;
      for (int i = 1; i <= m; i++) {
        sum += map.get(i);
      }
      System.out.println(sum);
    }
  }
}
