package aoj.v0;

import java.util.Scanner;

public class Tmp {
    public static Scanner sc;
    /* 最大部分和 */
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        while (solve()) {
        }
        sc.close();
    }

    public static boolean solve() {
        int n = sc.nextInt();
        if (n == 0) {
            return false;
        }
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = dp(a, 0, 0);
        System.out.println(m);
        return true;
    }

    public static int dp(int[] m, int sum, int k) {
        if (k == m.length) {
            return sum;
        }
        if (sum != 0) {
            return Math.max(sum, dp(m, sum + m[k], k + 1));
        }
        return Math.max(dp(m, 0, k + 1), dp(m, m[k], k + 1));
    }
}

/*
7
-5
-1
6
4
9
-6
-7

13
1
2
3
2
-2
-1
1
2
3
2
1
-2
1

3
1000
-200
201

0

 */