package acm.domestic.y2007;

import java.util.HashMap;
import java.util.Scanner;

public class QbLoginLogout {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      HashMap<Integer, Student> map = new HashMap<>();
      int n = sc.nextInt();
      int m = sc.nextInt();
      if ((n | m) == 0) {
        break;
      }
      for (int i = 0; i < m; i++) {
        map.put(i + 1, new Student(n));
      }
      int r = sc.nextInt();
      for (int i = 0; i < r; i++) {
        int t = sc.nextInt() - 540;
        int ni = sc.nextInt();
        int mi = sc.nextInt();
        int s = sc.nextInt();
        if (s == 1) {
          map.get(mi).login(ni, t);
        } else {
          map.get(mi).logout(ni, t);
        }
      }
      int q = sc.nextInt();
      for (int i = 0; i < q; i++) {
        int ts = sc.nextInt() - 540;
        int te = sc.nextInt() - 540;
        int m3 = sc.nextInt();
        int res = map.get(m3).time(ts, te);
        System.out.println(res);
      }
    }
  }

  static class Student {
    boolean[] login = new boolean[721];
    int[] cache;

    Student(int n) {
      this.cache = new int[n + 1];
    }

    void login(int n, int t) {
      cache[n] = t;
    }

    void logout(int n, int t) {
      for (int i = this.cache[n]; i < t; i++) {
        this.login[i] = true;
      }
    }

    int time(int ts, int te) {
      int c = 0;
      for (int i = ts; i < te; i++) {
        c += this.login[i] ? 1 : 0;
        // System.out.println(i + ":" + (this.login[i] ? 1 : 0));
      }
      return c;
    }
  }
}
