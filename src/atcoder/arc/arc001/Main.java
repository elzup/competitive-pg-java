package atcoder.arc.arc001;

import java.util.Scanner;

public class Main {

    public static int[][] res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[8][8];
        int k = 1;
        for (int i = 0; i < 8; i++) {
            String line = sc.next();
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'Q') {
                    put(j, i, map, k);
                    k ++;
                }
            }
        }
        // arrayDump(map);
        if (!dp(map, 4)) {
            System.out.println("No Answer");
            return;
        }
        print(map);
        // arrayDump(map);
    }

    public static boolean dp(int[][] map, int k) {
        if (k == 9) {
            res = map;
            return true;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] == 0) {
                    put(j, i, map, k);
                    if (dp(map, k + 1)) {
                        return true;
                    }
                    trim(map, k);
                }
            }
        }
        return false;
    }

    public static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] >= 10 ? "Q" : ".");
            }
            System.out.println();
        }
    }

    public static void arrayDump(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.printf("%3d", a[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void trim(int[][] map, int k) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] % 10 == k) {
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void put(int x, int y, int[][] map, int k) {
        map[y][x] = k + 10;
        for (int i = x + 1; i < 8; i++) {
            checkPut(i, y, map, k);
        }
        for (int i = x - 1; i >= 0; i--) {
            checkPut(i, y, map, k);
        }
        for (int i = y + 1; i < 8; i++) {
            checkPut(x, i, map, k);
        }
        for (int i = y - 1; i >= 0; i--) {
            checkPut(x, i, map, k);
        }
        for (int d = 1; x + d < 8 && y + d < 8; d++) {
            checkPut(x + d, y + d, map, k);
        }
        for (int d = 1; x - d >= 0 && y + d < 8; d++) {
            checkPut(x - d, y + d, map, k);
        }
        for (int d = 1; x + d < 8 && y - d >= 0; d++) {
            checkPut(x + d, y - d, map, k);
        }
        for (int d = 1; x - d >= 0 && y - d >= 0; d++) {
            checkPut(x - d, y - d, map, k);
        }
    }

    public static boolean checkPut(int x, int y, int[][] map, int k) {
        if (map[y][x] >= 10) {
            System.out.println("No Answer");
            System.exit(0);
        }
        if (map[y][x] == 0) {
            map[y][x] = k;
        }
        return true;
    }
}

