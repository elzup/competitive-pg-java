package acm.domestic_pre.y2017;

import java.util.HashMap;
import java.util.Scanner;

public class C {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      if ((n | m) == 0) {
        break;
      }
      HashMap<Integer, Integer> min = new HashMap<>();
      HashMap<Integer, Integer> max = new HashMap<>();
      for (int i = 1; i <= m; i++) {
        min.put(i, 0);
        max.put(i, 0);
      }

      for (int i = 0; i < n; i++) {
        int p = sc.nextInt();
        int k = sc.nextInt();
        for (int j = 0; j < k; j++) {
          int c = sc.nextInt();
          if (k == 1) {
            min.put(c, min.get(c) + p);
          }
          max.put(c, max.get(c) + p);
        }
      }

      int max1v = 0;
      int max1k = 0;
      int max2v = 0;
      int max2k = 0;
      int min1v = Integer.MAX_VALUE;
      int min1k = Integer.MAX_VALUE;
      int min2v = Integer.MAX_VALUE;
      int min2k = Integer.MAX_VALUE;
      for (int i = 1; i <= m; i++) {
        int minv = min.get(i);
        if (min1v > minv) {
          min2v = min1v;
          min2k = min1k;
          min1v = minv;
          min1k = i;
        } else if (min2v > minv) {
          min2v = minv;
          min2k = i;
        }
        int maxv = max.get(i);
        if (max1v < maxv) {
          max2v = max1v;
          max2k = max1k;
          max1v = maxv;
          max1k = i;
        } else if (max2v < maxv) {
          max2v = maxv;
          max2k = i;
        }
      }
      if (max1k != min1k) {
        System.out.println(max1v - min1v + 1);
      } else {
        int v = Math.max(max1v - min2v, max2v - min1v);
        System.out.println(v + 1);
      }
    }
  }
}
