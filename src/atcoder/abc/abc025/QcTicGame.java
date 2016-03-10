package atcoder.abc.abc025;

import java.util.*;

public class QcTicGame {
    public static int[][] mapB, mapC;
    public static int pointSum;
    public static int CHOKUDAI = -1;
    public static int CHOKUSHO = 1;
    public static int NOHAND = 0;
    public static HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mapB = new int[2][3];
        mapC = new int[3][2];
        pointSum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                mapB[i][j] = sc.nextInt();
                pointSum += mapB[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                mapC[i][j] = sc.nextInt();
                pointSum += mapC[i][j];
            }
        }

        // cmp: chokudai_max_point
        int cmp = calc(CHOKUDAI, new int[3][3], 0);
        System.out.println(cmp);
        System.out.println(pointSum - cmp);
    }

    public static int calc(int hand, int[][] map, int k) {
        if (k == 9) {
            return point(map);
        }
        int p = -1;
        for (int i = 0; i < 9 - k; i++) {
            int pos = putForEmpty(map, i);
            int pi = pos / 3;
            int pj = pos % 3;
            map[pi][pj] = hand;
            if (p == -1) {
                p = calc(-hand, map, k + 1);
            } else {
                if (hand == CHOKUDAI) {
                    p = Math.max(p, calc(-hand, map, k + 1));
                } else {
                    p = Math.min(p, calc(-hand, map, k + 1));
                }
            }
            map[pi][pj] = NOHAND;
        }
        return p;
    }

    /* t + 1番目に空のマスの座標を返す */
    public static int putForEmpty(int[][] map, int t) {
        int ec = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == NOHAND) {
                    ec ++;
                    if (ec == t + 1) {
                        return i * 3 + j;
                    }
                }
            }
        }
        return -1;
    }

    public static int point(int[][] map) {
        int key = toKey(map);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int p = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i < 2 && map[i][j] == map[i + 1][j]) {
                    p += mapB[i][j];
                }
                if (j < 2 && map[i][j] == map[i][j + 1]) {
                    p += mapC[i][j];
                }
            }
        }
        memo.put(key, p);
        return p;
    }

    public static int toKey(int[][] map) {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == CHOKUDAI) {
                    k |= 1 << (i * 3 + j);
                }
            }
        }
        return k;
    }
}
