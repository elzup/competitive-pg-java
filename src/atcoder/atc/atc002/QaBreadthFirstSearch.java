package atcoder.atc.atc002;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class QaBreadthFirstSearch {

    public static final long mod7 = 1000000007L;
    /**
     * 幅優先探索
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int sy = sc.nextInt() - 1;
        int sx = sc.nextInt() - 1;
        int gy = sc.nextInt() - 1;
        int gx = sc.nextInt() - 1;
        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String line = sc.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j) == '#' ? -1 : 0;
            }
        }
        Point start = new Point(sx, sy);
        Point goal = new Point(gx, gy);

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(start);
        int[] dx = new int[]{ 0, 1, 0, -1};
        int[] dy = new int[]{ -1, 0, 1, 0};
        int last = 0;
        // System.out.println("start: " + start);
        // System.out.println(" goal: " + goal);

        while (queue.size() > 0) {
            Point p = queue.poll();
            // System.out.println(p);
            if (p.equals(goal)) {
                last = map[p.y][p.x] + 1;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                Point np = new Point(nx, ny);
                if (nx < 0 || c <= nx || ny < 0 || r <= ny || map[ny][nx] != 0) {
                    continue;
                }
                map[ny][nx] = map[p.y][p.x] + 1;
                queue.add(np);
            }
            // arryaDump(map);
        }
        System.out.println(last - 1);
    }

    public static void arryaDump(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static class Point {
        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Point p) {
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }

}
