package acm.tokyo2012_2;

import java.util.Scanner;

public class QcDice {
    static int[][] hMap, nMap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            hMap = new int[4 * n][4 * n];
            nMap = new int[4 * n][4 * n];
            for (int i = 0; i < n; i++) {
                int t = sc.nextInt();
                int f = sc.nextInt();
                Dice dice = new Dice(t, f);
                dp(dice, n * 2, n * 2);
                // System.out.println(i + ": ");
                // System.out.println("h");
                // arrayDump(hMap);
                // System.out.println("n");
                // arrayDump(nMap);
            }
            int[] res = new int[6];
            for (int i = 0; i < 4 * n; i++) {
                for (int j = 0; j < 4 * n; j++) {
                    if (nMap[i][j] > 0) {
                        res[nMap[i][j] - 1] ++;
                    }
                }
            }
            System.out.print(res[0]);
            for (int i = 1; i < 6; i++) {
                System.out.print(" " + res[i]);
            }
            System.out.println();
        }
    }

    public static void arrayDump(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void dp(Dice dice, int y, int x) {
        int[] d = new int[]{ -1, 0, 1, 0, -1};
        for (int i = 6; i >= 4; i--) {
            int h = hMap[y][x];
            for (int j = 0; j < 4; j++) {
                int dh = hMap[y + d[j]][x + d[j + 1]];
                if (dh < h && dice.dice[j + 1] == i) {
                    dice.dice = dice.roll(j + 1);
                    dp(dice, y + d[j], x + d[j + 1]);
                    return;
                }
            }
        }
        hMap[y][x] += 1;
        nMap[y][x] = dice.dice[0];
    }

    static class Dice {
        public int[] dice;
        static int[][] dice_table =
                {{0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 3, 5, 2, 4, 0},
                        {0, 4, 0, 1, 6, 0, 3},
                        {0, 2, 6, 0, 0, 1, 5},
                        {0, 5, 1, 0, 0, 6, 2},
                        {0, 3, 0, 6, 1, 0, 4},
                        {0, 0, 4, 2, 5, 3, 0}
                };

        Dice(int x, int y) {
            dice = new int[6];
            dice[0] = x;
            dice[1] = y;
            dice[2] = dice_table[x][y];
            dice[3] = 7 - y;
            dice[4] = dice_table[y][x];
            dice[5] = 7 - x;
        }

        public void rollUp() {
            this.dice = this.roll(3); // 3
        }

        public void rollDown() {
            this.dice = this.roll(1); // 1
        }

        public void rollRight() {
            this.dice = this.roll(2); //4
        }

        public void rollLeft() {
            this.dice = this.roll(4); // 2
        }

        // http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0502
        int[] roll(int dir) {
            int[] b = new int[6];
            if (dir == 1) {// South
                b[0] = dice[3];
                b[1] = dice[0];
                b[2] = dice[2];
                b[3] = dice[5];
                b[4] = dice[4];
                b[5] = dice[1];
            } else if (dir == 2) {// East
                b[0] = dice[4];
                b[1] = dice[1];
                b[2] = dice[0];
                b[3] = dice[3];
                b[4] = dice[5];
                b[5] = dice[2];
            } else if (dir == 3) {// North
                b[0] = dice[1];
                b[1] = dice[5];
                b[2] = dice[2];
                b[3] = dice[0];
                b[4] = dice[4];
                b[5] = dice[3];
            } else if (dir == 4) {// West
                b[0] = dice[2];
                b[1] = dice[1];
                b[2] = dice[5];
                b[3] = dice[3];
                b[4] = dice[0];
                b[5] = dice[4];
            } else if (dir == 5) {// Left
                b[0] = dice[0];
                b[1] = dice[4];
                b[2] = dice[1];
                b[3] = dice[2];
                b[4] = dice[3];
                b[5] = dice[5];
            } else {// Right
                b[0] = dice[0];
                b[1] = dice[2];
                b[2] = dice[3];
                b[3] = dice[4];
                b[4] = dice[1];
                b[5] = dice[5];
            }
            return b;
        }
    }
}

