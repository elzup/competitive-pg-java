package acm.domestic.y2014_2;

import java.util.Scanner;

public class QbPuzzle {
    public static int h, w;
    public static int[][] map, checkMap;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            h = sc.nextInt();
            if (h == 0) {
                break;
            }
            w = 5;
            map = new int[h][5];
            checkMap = new int[h][5];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < 5; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            System.out.println(point());
        }
    }

    public static int point() {
        int p = 0;
        while (true) {
            arrayDump(map);
            for (int i = 0; i < h; i++) {
                checkLine(i);
            }
            arrayDump(checkMap);
            int res = calc();
            drop();
            arrayDump(map);
            p += res;
            if (res == 0) {
                break;
            }
        }
        return p;
    }

    public static void drop() {
        for (int i = 0; i < h; i++) {
            for (int j = h - 2; j >= 0; j--) {
                for (int k = 0; k < w; k++) {
                    if (map[j + 1][k] == 0) {
                        map[j + 1][k] = map[j][k];
                        map[j][k] = 0;
                    }
                }
            }
        }
    }

    public static int calc() {
        int p = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (checkMap[i][j] == 1) {
                    p += map[i][j];
                    checkMap[i][j] = 0;
                    map[i][j] = 0;
                }
            }
        }
        return p;
    }

    public static void checkLine(int i) {
        int chain = 0;
        int current = 0;
        for (int j = 0; j < w; j++) {
            if (map[i][j] != current) {
                if (chain >= 3) {
                    for (int rj = 0; rj < chain; rj++) {
                        checkMap[i][j - rj - 1] = 1;
                    }
                }
                current = map[i][j];
                chain = 1;
                continue;
            }
            chain ++;
        }
        if (chain >= 3) {
            for (int rj = 0; rj < chain; rj++) {
                checkMap[i][w - rj - 1] = 1;
            }
        }
    }

    public static void arrayDump(int[][] list) {
        return;
        // for (int i = 0; i < list.length; i++) {
        //     for (int j = 0; j < list[0].length; j++) {
        //         System.out.print(list[i][j] + ", ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
    }

}
