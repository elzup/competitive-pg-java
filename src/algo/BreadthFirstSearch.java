package algo;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

// 幅優先探索
public class BreadthFirstSearch {

    public static final long mod7 = 1000000007L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int sy = sc.nextInt() - 1;
        int sx = sc.nextInt() - 1;
        int ey = sc.nextInt() - 1;
        int ex = sc.nextInt() - 1;
        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String line = sc.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j) == '#' ? -1 : 0;
            }
        }
        Queue<Integer> queueX = new ArrayDeque<>();
        Queue<Integer> queueY = new ArrayDeque<>();
        queueX.add(sx);
        queueY.add(sy);
        int[] vec = new int[]{ 0, 1, 0, -1, 0};
        while (!(sx == ex && sy == ey)) {
            // System.out.println(p);
            for (int i = 0; i < 4; i++) {
                int nx = vec[i] + sx;
                int ny = vec[i + 1] + sy;
                if (nx < 0 || c <= nx || ny < 0 || r <= ny || map[ny][nx] != 0) {
                    continue;
                }
                map[ny][nx] = map[sy][sx] + 1;
                queueX.add(nx);
                queueY.add(ny);
            }
            sx = queueX.poll();
            sy = queueY.poll();
        }
        System.out.println(map[ey][ex]);
    }
}
