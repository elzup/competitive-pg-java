package acm.domestic.y2023;


import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            int[] m = new int[n];
            for (int i = 0; i < n; i++) m[i] = sc.nextInt();
            solve(n, m);
        }

    }

    private static void solve(int n, int[] m) {
        int d = 1000000000;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int t = Math.abs(m[i] - 2023);
            if (d > t) {
                d = t;
                ans = i + 1;
            }
        }
        System.out.println(ans);
    }
}
