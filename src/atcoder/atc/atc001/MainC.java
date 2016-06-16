package atcoder.atc.atc001;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MainC {

    public static Deque<Integer> stack;
    public static int[][] map;

    public static final int GOAL = 2;
    public static final int START = 1;
    public static final int EMP = 0;
    public static final int WALL = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        sc.nextLine();
        stack = new ArrayDeque<>();
        map = new int[h][w];

        for (int i = 0; i < h; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < w; j++) {
                char c = line.charAt(j);
                if (c == '#') {
                    map[i][j] = WALL;
                } else if (c == 'g') {
                    map[i][j] = GOAL;
                } else if (c == 's') {
                    stack.addFirst(i * w + j);
                    map[i][j] = EMP;
                } else{
                    map[i][j] = EMP;
                }
            }
        }
        while (stack.size() > 0) {
            // System.out.println(stack.size() + ", " + stack.getFirst());
            int i = stack.getFirst() / w;
            int j = stack.getFirst() % w;
            // System.out.println(i + ": " + j + " >" + map[i][j]);
            // arrayDump(map);
            if (map[i][j] == GOAL) {
                System.out.println("Yes");
                return;
            }
            map[i][j] = WALL;
            if (i > 0 && map[i - 1][j] != WALL) {
                stack.addFirst((i - 1) * w + j);
                // System.out.println("<i");
                continue;
            } else if (j > 0 && map[i][j - 1] != WALL) {
                stack.addFirst(i * w + (j - 1));
                // System.out.println("<j");
                continue;
            } else if (i < h - 1 && map[i + 1][j] != WALL) {
                stack.addFirst((i + 1) * w + j);
                // System.out.println("i>");
                continue;
            } else if (j < w - 1 && map[i][j + 1] != WALL) {
                stack.addFirst(i * w + (j + 1));
                // System.out.println("j>");
                continue;
            } else {
                // System.out.println("pop" + stack.getFirst());
                stack.removeFirst();
            }
        }
        System.out.println("No");
    }

    public static void arrayDump(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------");
    }
}
