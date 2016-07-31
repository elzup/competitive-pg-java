package acm.domestic.y2016;

import java.util.Scanner;

public class D {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = (sc.nextInt());
            }

            boolean[][] dp = new boolean[n][n];
            boolean[] check = new boolean[n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }
            for (int w = 2; w <= n; w += 2) {
                for (int j = 0; j <= n - w; j++) {
                    int l = j;
                    int r = (j + w - 1);
                    if (w == 2) {
                        if (Math.abs(a[l] - a[r]) > 1) {
                            continue;
                        }
                        dp[l][r] = true;
                        check[l] = check[r] = true;
                        continue;
                    }
                    if (dp[l][r - 2] && dp[r - 1][r]) {
                        check[r - 1] = check[r] = true;
                        dp[l][r] = true;
                    }
                    if (dp[l + 1][r - 1] && Math.abs(a[l] - a[r]) <= 1) {
                        check[l] = check[r] = true;
                        dp[l][r] = true;
                    }
                    if (dp[l + 2][r] && dp[l][l + 1]) {
                        check[l] = check[l + 1] = true;
                        dp[l][r] = true;
                    }
                }
            }
            int t = 0;
            for (boolean c : check) {
                if (c) {
                    t++;
                }
            }
            System.out.println(t - (t % 2));

            // ArrayList<Integer> w = new ArrayList<>();
            // for (int i = 0; i < n; i++) {
            //     w.add(sc.nextInt());
            // }
            // for (int i = 1000; w.size() > 1 && i > 0; i--) {
            //     for (int j = 0; j < w.size() - 1; j++) {
            //         int t = w.get(j);
            //         if (t == i && Math.abs(w.get(j + 1) - t) <= 1) {
            //             w.remove(j);
            //             w.remove(j);
            //             j -= 2;
            //             if (j <= 0) {
            //                 break;
            //             }
            //         }
            //     }
            // }
            // System.out.println(n - w.size());
        }
    }

    // static int dp(Integer[] a, int t) {
    //     if (memo.containsKey(a)) {
    //         return memo.get(a);
    //     }
    //     int pre = -1;
    //     int min = t;
    //     if (min < 2) {
    //         return t;
    //     }
    //     for (int i = 0; i < a.length; i++) {
    //         if (a[i] == 0) {
    //             continue;
    //         }
    //         if (pre == -1) {
    //             pre = i;
    //             continue;
    //         }
    //         int d = Math.abs(a[i] - a[pre]);
    //         if (d > 1) {
    //             pre = i;
    //             continue;
    //         }
    //         Integer[] a2 = new Integer[a.length - 2];
    //         int jj = 0;
    //         for (int j = 0; j < a.length; j++) {
    //             if (j == i || j == pre) {
    //                 jj ++;
    //                 continue;
    //             }
    //             a2[j - jj] = a[j];
    //         }
    //         min = Math.min(min, dp(a2, t - 2));
    //         pre = i;
    //     }
    //     memo.put(a, min);
    //     return min;
    // }
}
