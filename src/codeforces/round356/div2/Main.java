package codeforces.round356.div2;

import java.util.Scanner;

// http://codeforces.com/contest/680/problem/D
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        int t = max_tri(m) + 1;
        int[][] dp = new int[t][];
    }

    static int max_tri(long m) {
        int l = 0;
        int r = 100000;
        while (l < r) {
            int c = (r + l) / 2;
            long c3 = c * c * c;
            if (c3 == m) {
                return c;
            } else if (c3 > m) {
                r = c - 1;
            } else {
                l = c + 1;
            }
        }
        return l;
    }
}
