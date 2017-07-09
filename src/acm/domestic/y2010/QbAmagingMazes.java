package acm.domestic.y2010;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class QbAmagingMazes {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (run(sc)) {
    }
  }
  public static boolean run(Scanner sc) {
    int w = sc.nextInt();
    int h = sc.nextInt();
    if (w + h == 0) {
      return false;
    }
    int sy = 0;
    int sx = 0;
    int ey = h - 1;
    int ex = w - 1;
    int[][] map = new int[h][w];
    map[sy][sx] = 1;
    boolean[][][][] wall = new boolean[h][w][h][w];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w - 1; j++) {
        wall[i][j][i][j + 1] = wall[i][j + 1][i][j] = sc.nextInt() == 1;
      }
      if (i == h - 1) {
        continue;
      }
      for (int j = 0; j < w; j++) {
        wall[i + 1][j][i][j] = wall[i][j][i + 1][j] = sc.nextInt() == 1;
      }
    }
    Queue<Integer> queueX = new ArrayDeque<>();
    Queue<Integer> queueY = new ArrayDeque<>();
    queueX.add(sx);
    queueY.add(sy);
    int[] vec = new int[]{0, 1, 0, -1, 0};
    while (!(sx == ex && sy == ey)) {
      // System.out.println(p);
      for (int i = 0; i < 4; i++) {
        int nx = vec[i] + sx;
        int ny = vec[i + 1] + sy;
        if (nx < 0 || w <= nx || ny < 0 || h <= ny || map[ny][nx] != 0) {
          continue;
        }
        if (wall[sy][sx][ny][nx]) {
          continue;
        }
        map[ny][nx] = map[sy][sx] + 1;
        queueX.add(nx);
        queueY.add(ny);
      }
      if (queueX.size() == 0) {
        break;
      }
      sx = queueX.poll();
      sy = queueY.poll();
    }
    System.out.println(map[ey][ex]);
    return true;
  }
}
