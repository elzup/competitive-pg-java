package acm.domestic.y2017;

import java.util.Scanner;

public class C {

  public static int h, w;
  public static int h1, h2, w1, w2;
  public static int[][] a;
  public static int t;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      h = sc.nextInt();
      w = sc.nextInt();
      if (h + w == 0) {
        break;
      } a = new int[h][w];
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          a[i][j] = sc.nextInt();
        }
      }
      int max = 0;
      for (t = 0; t <= 8; t++) {
//      System.out.println("t: " + t);
        for (int j = 1; j < h - 1; j++) {
          for (int k = 1; k < w - 1; k++) {
            if (t < a[j][k]) {
              continue;
            }
            int bt = j;
            for (int i = 0; i < 100; i++) {
              if (bt >= h || a[bt][k] > t) {
                bt--;
                break;
              }
              bt++;
            }
            int to = j;
            for (int i = 0; i < 100; i++) {
              if (to < 0 || a[to][k] > t) {
                to++;
                break;
              }
              to--;
            }
            int le = k;
            for (int i = 0; i < 100; i++) {
              if (le >= w || a[j][le] > t) {
                le--;
                break;
              }
              le++;
            }
            int re = k;
            for (int i = 0; i < 100; i++) {
              if (re < 0 || a[j][re] > t) {
                re++;
                break;
              }
              re--;
            }
            if (bt == h - 1 || to == 0 || le == w - 1 || re == 0) {
//            System.out.println("over out");
              continue;
            }
//          System.out.println(bt + ":" + to + ":" + le + ":" + re);
            // 埋まってるかチェック
            boolean all = true;
            int sum = 0;
            for (int i = to; i <= bt; i++) {
              for (int l = re; l <= le; l++) {
                if (t < a[i][l]) {
                  all = false;
                  break;
                }
                sum += (t + 1) - a[i][l];
              }
              if (!all) {
                break;
              }
            }
            if (!all) {
//            System.out.println("fill out");
              continue;
            }
            // 辺チェック
            for (int i = to - 1; i <= bt + 1; i++) {
              if (a[i][re - 1] <= t || a[i][le + 1] <= t) {
                all = false;
                break;
              }
            }
            for (int l = re - 1; l <= le + 1; l++) {
              if (a[to - 1][l] <= t || a[bt + 1][l] <= t) {
                all = false;
                break;
              }
            }
            if (!all) {
//            System.out.println("bar out");
              continue;
            }
            max = Math.max(max, sum);
          }
        }
      }
      System.out.println(max);
    }
  }
}
