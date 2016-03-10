package atcoder.abc.abc025;

import java.util.HashMap;
import java.util.Scanner;

public class Qd25Integer {
    public static int[] check;
    public static HashMap<Integer, Long> memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        check = new int[26];
        memo = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int n = sc.nextInt();
                if (n != 0) {
                    check[n] = i * 5 + j + 1;
                }
            }
        }
        System.out.println(dp(check, 1, 0));
    }

    public static long dp(int[] check, int k, int mapKey) {
        if (k == 26) {
            return 1;
        }
        if (memo.containsKey(mapKey)) {
            return memo.get(mapKey);
        }
        long s = 0;
        if (check[k] != 0) {
            int i = (check[k] - 1) / 5;
            int j = (check[k] - 1) % 5;

            if (checkPut(i, j, mapKey)) {
                s = dp(check, k + 1, mapKey | (1 << i * 5 + j));
            }
        } else {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (checkPut(i, j, mapKey)) {
                        s += dp(check, k + 1, mapKey | 1 << i * 5 + j);
                    }
                }
            }
        }
        memo.put(mapKey, s);
        return s;
    }

    public static boolean checkPut(int i, int j, int mapKey) {
        int t = (i * 5 + j);
        int k = (mapKey >> t) & 1;
        if (k == 1) {
            return false;
        }
        if ((1 <= j && j <= 3) &&
                ((((mapKey >> (t - 1)) & 1) ^ ((mapKey >> (t + 1)) & 1)) == 1)) {
            return false;
        }
        if ((1 <= i && i <= 3) &&
                ((((mapKey >> (t - 5)) & 1) ^ ((mapKey >> (t + 5)) & 1)) == 1)) {
            return false;
        }
        return true;
    }

    public static void arrayDump(boolean[][] map) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(map[i][j] ? "1" : "0");
            }
            System.out.println();
        }
        System.out.println("---");
    }
}
