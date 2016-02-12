package atcoder.arc001;

import java.util.Scanner;

public class Main {

    public static int[][] res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[8][8];
        for (int i = 0; i < 8; i++) {
            String line = sc.next();
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'Q') {
                    put(j, i, map);
                }
            }
        }
        arrayDump(map);
        dp(map, 3, new int[8][2]);
        arrayDump(map);
    }

    public static boolean dp(int[][] map, int k, int[][] pos) {
        if (k == 8) {
            res = map;
            return true;
        }
        return false;
    }

    public static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] == 1 ? "." : "Q");
            }
            System.out.println();
        }
        System.out.println();
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

    public static void put(int x, int y, int[][] map) {
        map[y][x] = 1;
        for (int i = x + 1; i < 8; i++) {
            map[y][i] = 1;
        }
        for (int i = x - 1; i >= 0; i--) {
            map[y][i] = 1;
        }
        for (int i = y + 1; i < 8; i++) {
            map[i][x] = 1;
        }
        for (int i = y - 1; i >= 0; i--) {
            map[i][x] = 1;
        }
        for (int d = 0; x + d < 8 && y + d < 8; d++) {
            map[y + d][x + d] = 1;
        }
        for (int d = 0; x - d >= 0 && y + d < 8; d++) {
            map[y + d][x - d] = 1;
        }
        for (int d = 0; x + d < 8 && y - d >= 0; d++) {
            map[y - d][x + d] = 1;
        }
        for (int d = 0; x - d >= 0 && y - d >= 0; d++) {
            map[y - d][x - d] = 1;
        }
    }
}
