package acm.domestic.y2005;

import java.util.Scanner;

public class QbPolygonalLineSearch {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (run(sc)) {}
  }

  static boolean run(Scanner sc) {
    int n = sc.nextInt();
    if (n == 0) {
      return false;
    }
    String k = "";
    for (int i = 0; i < n + 1; i++) {
      int m = sc.nextInt();
      int[] x = new int [m];
      int[] y = new int [m];
      for (int j = 0; j < m; j++) {
        x[j] = sc.nextInt();
        y[j] = sc.nextInt();
      }
      String id = normalize2(x, y);
      // System.out.println(i + " : " + id);
      if (i == 0) {
        k = id;
      } else {
        if (k.equals(id)) {
          System.out.println(i);
        }
      }
    }
    System.out.println("+++++");
    return true;
  }

  static String normalize2(int x[], int y[]) {
    int l = x.length;
    int[] ids1 = normalize(x, y);
    int[] ids2 = new int[ids1.length];
    for (int i = 0; i < ids1.length; i++) {
      ids2[i] = ids1[ids1.length - i - 1];
    }
    for (int i = 1; i < ids2.length; i += 2) {
      ids2[i] = ~ids2[i] + 2;
    }
    String id1 = "";
    String id2 = "";
    for (int i = 0; i < ids1.length; i += 2) {
      id1 += ids1[i];
      id2 += ids2[i];
      if (i + 1 < ids1.length) {
        id1 += "rl".charAt(ids1[i + 1]);
        id2 += "rl".charAt(ids2[i + 1]);
      }
    }
    return id1.compareTo(id2) > 0 ? id1 + id2 : id2 + id1;
  }

  static int[] normalize(int x[], int y[]) {
    int d = dir(x[0], y[0], x[1], y[1]);
    int l = Math.abs(x[0] - x[1]) + Math.abs(y[0] - y[1]);
    int[] ids = new int[(x.length - 1) * 2 - 1];
    ids[0] = l;
    for (int i = 1; i + 1 < x.length; i++) {
      int[] dx = dirx(x[i], y[i], x[i + 1], y[i + 1], d);
      int d2 = dx[0];
      d = dx[1];
      int l2 = Math.abs(x[i] - x[i + 1]) + Math.abs(y[i] - y[i + 1]);
      ids[i * 2 - 1] = d2;
      ids[i * 2] = l2;
    }
    return ids;
  }

  static int D1 = 0;
  static int D2 = 1;
  static int D3 = 2;
  static int D4 = 3;

  static int[] dirx(int x1, int y1, int x2, int y2, int d) {
    if (d == D1) {
      return x1 < x2 ? new int[]{ 0, D2 } : new int[]{ 1, D4 };
    } else if (d == D3) {
      return x1 < x2 ? new int[]{ 1, D2 } : new int[]{ 0, D4 };
    } else if (d == D2) {
      return y1 < y2 ? new int[]{ 1, D1 } : new int[]{ 0, D3 };
    } else {
      return y1 < y2 ? new int[]{ 0, D1 } : new int[]{ 1, D3 };
    }
  }

  static int dir(int x1, int y1, int x2, int y2) {
    if (x1 == x2) {
      return y1 < y2 ? D1 : D3;
    }
    return x1 < x2 ? D2 : D4;
  }
}
