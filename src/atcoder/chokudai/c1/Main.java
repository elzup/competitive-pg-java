package atcoder.chokudai.c1;

import java.util.*;

public class Main {

    static int[][] map;
    static int w = 30;
    static int wn = w * w;
    static HashMap<Integer, Integer> pmap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        pmap = new HashMap<>();
        pmap.put(0, 0);
        map = new int[w][w];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < w; j++) {
                int p = sc.nextInt();
                if (!pmap.containsKey(p)) {
                    pmap.put(p, 1);
                } else {
                    pmap.put(p, pmap.get(p) + 1);
                }

                map[i][j] = p;
            }
        }
        // printArray(map);
        // 全て0になるまで
        while (pmap.get(0) != wn) {
            // SortedSet<Integer> keys = new TreeSet<>(pmap.keySet());
            int vm = Collections.max(pmap.keySet());
            for (int i = w - 1; i >= 0; i--) {
                for (int j = w - 1; j >= 0; j--) {
                    if (map[i][j] == vm) {
                        // System.out.println(i + ", " + j);
                        check(i, j, vm);
                    }
                }
            }
            // printArray(map);
        }
    }

    public static boolean check(int x, int y, int t) {
        if (t == 0) {
            return true;
        }
        if (map[x][y] != t) {
            return false;
        }
        map[x][y] --;
        System.out.println((x + 1) + " " + (y + 1));
        int pv = pmap.get(t);
        pmap.put(t, pv - 1);
        pmap.put(t - 1, pmap.get(t - 1) + 1);
        if (pv == 1) {
            pmap.remove(t);
        }

        int[][] d = new int[][]{{ -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }};
        for (int i = 0; i < 4; i++) {
            int nx = x + d[i][0];
            int ny = y + d[i][1];
            if (0 <= nx && nx < w && 0 <= ny && ny < w) {
                if (check(nx, ny, t - 1)) {
                    return true;
                }
            }
        }
        return true;
    }


    public static void printArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.printf("%3d ", a[i][j]);
            }
            System.out.println();
        }
        System.out.printf("-----");
    }
}
