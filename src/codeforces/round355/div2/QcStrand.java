package codeforces.round355.div2;

import java.util.Scanner;

public class QcStrand {
    public static final long mod7 = 1000000007L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        long t = 0;
        int[] lib = new int[] { 1, 2, 4, 8, 16, 32, 64 };
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int a = toDec(c);
            t += countZero(a);
            // System.out.println(c + ": " + a + " - " + countZero(a) + " - " + t);
        }
        // System.out.println(t);
        long res = power(3, t, mod7);
        System.out.println(res);
    }

    public static int toDec(char s) {
        if (s == '_') {
            return 63;
        }
        if (s == '-') {
            return 62;
        }
        if ('0' <= s && s <= '9') {
            return Integer.valueOf(s + "");
        }
        if ('a' <= s && s <= 'z') {
            return ((int) s) - 97 + 36;
        }
        return ((int) s) - 65 + 10;
    }

    public static int countZero(int n) {
        int t = 0;
        // System.out.println();
        for (int i = 0; i < 6; i++) {
            // System.out.print((n >> i) & 1);
            t += ((n >> i) & 1);
        }
        // System.out.println();
        return 6 - t;
    }

    public static long power(long n, long k, long mod) {
        if (k == 0) {
            return 1;
        } else if (k % 2 == 0) {
            long t = power(n, k / 2, mod);
            return ((t % mod) * (t % mod)) % mod;
        }
        return n * power(n, k - 1, mod) % mod;
    }
}
