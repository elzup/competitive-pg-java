package atcoder.arc038;

import java.util.Scanner;

public class Main {

    static int[][] m;
    static int W;
    static int H;
    static boolean[][] s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ps = sc.nextLine().split(" ");
        H = Integer.valueOf(ps[0]);
        W = Integer.valueOf(ps[1]);
        s = new boolean[H][W];
        m = new int[H][W];
        for (int h = 0; h < H; h++) {
            String cs = sc.nextLine();
            for (int w = 0; w < W; w++) {
                m[h][w] = 2;
                s[h][w] = cs.charAt(w) == '#';
            }
        }
        boolean k = judge(0, 0);
        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                System.out.print(m[h][w]);
            }
            System.out.println();
        }
        System.out.println(k ? "First" : "Second");
    }

    public static boolean judge(int j, int i) {
        if (j >= W || i >= H || s[j][i]) {
            return false;
        }
        if (m[j][i] != 2) {
            return m[j][i] == 1;
        }
        if (!judge(j + 1, i) || !judge(j, i + 1) || !judge(j + 1, i + 1)) {
            m[i][j] = 1;
            return true;
        }
        m[i][j] = 0;
        return false;
    }

}

