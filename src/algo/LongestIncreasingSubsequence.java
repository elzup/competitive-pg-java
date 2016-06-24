package algo;

import java.util.Arrays;
import java.util.Scanner;

// 最長増加部分列 LIS
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int in = lower_bound(dp, a[i]);
            if (in < n) {
                dp[in] = a[i];
            }
        }
        System.out.println(lower_bound(dp, Integer.MAX_VALUE));
    }

    static int lower_bound(int a[], int border) {
        int l = -1;
        int r = a.length;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (border <= a[mid]) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return r;
    }
}
