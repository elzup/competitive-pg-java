package atcoder.arc.arc001;

import java.util.Scanner;

public class QbRemoteController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(dp(a, b, 0));
    }

    public static int dp(int current, int target, int k) {
        // System.out.println(current + ":" + target + ":" + k);
        if (k > 8) {
            return Integer.MAX_VALUE;
        }
        if (current == target) {
            return k;
        }
        int m = Integer.MAX_VALUE;
        int[] ds;
        if (current < target) {
            ds = new int[]{1, 5, 10};
        } else {
            ds = new int[]{-1, -5, -10};
        }
        for (int i = 0; i < 3; i++) {
            m = Math.min(m, dp(current + ds[i], target, k + 1));
        }
        return m;
    }
}
