package acm.domestic.y2023;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            int m = sc.nextInt();
            int p = sc.nextInt() - 1;
            int q = sc.nextInt() - 1;
            int[] x = new int[m];
            for (int i = 0; i < m; i++) x[i] = sc.nextInt() - 1;
            solve(n, m, p, q, x);
        }

    }

    private static void solve(int n, int m, int p, int q, int[] x) {
        // 1本入れた時にそこにいる可能性があるかどうかで DP をする
        // [線を入れた本数 0 | 1][x座標]
        int[][] drawPos = new int[n][2];

        for (int i = 0; i < n; i++) {
            drawPos[i] = new int[]{-1, -1};
        }
        int t = p;

        for (int i = 0; i <= m; i++) {
//            System.out.println(t);
            if (t - 1 >= 0 && drawPos[t - 1][0] < 0) {
                drawPos[t - 1] = new int[]{i, t - 1};
            }
            if (t + 1 < n && drawPos[t + 1][0] < 0) {
                drawPos[t + 1] = new int[]{i, t};
            }
//            for (int[] pos : drawPos)
//                System.out.print((pos[0] == -1 ? "-" : pos[0]) + " ");
//            System.out.println();
            if (m == i) break;
            int xt = x[i];

            // xt  と xt + 1 の swap
            if (xt == t) t = xt + 1;
            else if (xt + 1 == t) t = xt;


            int[] tmp = drawPos[xt];
            drawPos[xt] = drawPos[xt + 1];
            drawPos[xt + 1] = tmp;

//            for (int[] pos : drawPos) System.out.print((pos[0] == -1 ? "-" : pos[0]) + " ");
        }

        if (q == t) System.out.println("OK");
        else if (drawPos[q][0] != -1)
            System.out.println((drawPos[q][1] + 1) + " " + (drawPos[q][0]));
        else System.out.println("NG");
    }
}
