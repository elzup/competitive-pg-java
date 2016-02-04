package atcoder.abc029;

import java.util.Scanner;

public class QcAbc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        dp(new StringBuilder(), 0, n);
    }

    public static void dp(StringBuilder sb, int k, int max) {
        // System.out.println(sb + ":" + k + ":" + max);
        if (k == max) {
            System.out.println(sb);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (sb.length() <= k) {
                sb.append("abc".charAt(i));
            } else {
                sb.setCharAt(k, "abc".charAt(i));
            }
            dp(sb, k + 1, max);
        }
    }
}
