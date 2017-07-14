package atcoder.dp_typical;

import java.util.*;

public class H {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int W = sc.nextInt();
    int C = sc.nextInt();
    int BEF = 0;
    int AFT = 1;

    ArrayList<Item> items = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
      int w = sc.nextInt();
      int v = sc.nextInt();
      int c = sc.nextInt();
      items.add(new Item(w, v, c));
    }

    Collections.sort(items);
    HashMap<Integer, List<Item>> map = new HashMap<>();
    for (Item item : items) {
      if (!map.containsKey(item.c)) {
        map.put(item.c, new ArrayList<>());
      }
      map.get(item.c).add(item);
    }
    int cn = map.size();
    int[][][][] dp = new int[cn + 1][W + 1][C + 1][2];
    dp[0][0][0][0] = 1;
    int c = 0;

    for (List<Item> its : map.values()) {
      System.out.println(c);
      for (Item it : its) {
        System.out.println(it.v + ": " + it.c);
        for (int j = W - 1; j >= 0; j--) {
          for (int k = 0; k < C; k++) {
            if (dp[c][j][k][BEF] != 0) {
              int v = dp[c][j][k][BEF] + it.v;
              if (j + it.w <= W) {
                if (k + 1 <= C) {
                  dp[c + 1][j + it.w][k + 1][AFT] = Math.max(v, dp[c + 1][j + it.w][k + 1][AFT]);
                }
                dp[c + 1][j][k][BEF] = Math.max(dp[c][j][k][BEF], dp[c + 1][j][k][BEF]);
              }
            }
            if (dp[c][j][k][AFT] != 0) {
              int v = dp[c][j][k][AFT] + it.v;
              if (j + it.w <= W) {
                dp[c + 1][j + it.w][k][BEF] = Math.max(v, dp[c + 1][j + it.w][k][BEF]);
                // dp[c][j + it.w][k][AFT] = Math.max(v, dp[c + 1][j + it.w][k][AFT]);
              }
              dp[c + 1][j][k][BEF] = Math.max(dp[c][j][k][AFT], dp[c + 1][j][k][BEF]);
            }
          }
        }
        for (int i = 0; i <= W; i++) {
          for (int k = 0; k <= C; k++) {
            System.out.printf("(%3d: %3d), ", dp[c + 1][i][k][BEF] - 1, dp[c + 1][i][k][AFT] - 1);
          }
          System.out.println();
        }
      }
      c++;
    }
    for (int j = 0; j <= W; j++) {
      for (int k = 0; k < C; k++) {
        System.out.println(dp[N][j][k][0] - 1);
        System.out.println(dp[N][j][k][1] - 1);
      }
    }
  }

  static class Item implements Comparable {
    int w;
    int v;
    int c;

    Item(int w, int v, int c) {
      this.w = w;
      this.v = v;
      this.c = c;
    }

    @Override
    public int compareTo(Object o) {
      return this.c - ((Item) o).c;
    }
  }

}
