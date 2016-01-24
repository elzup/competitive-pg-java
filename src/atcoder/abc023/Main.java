package atcoder.abc023;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] rs = new int[n];
        int[] cs = new int[n];
        int[] rSum = new int[r];
        int[] cSum = new int[c];
        int[] rSumLib = new int[100001];
        int[] cSumLib = new int[100001];
        for (int i = 0; i < n; i++) {
            rs[i] = sc.nextInt() - 1;
            cs[i] = sc.nextInt() - 1;
            rSum[rs[i]] += 1;
            cSum[cs[i]] += 1;
        }
        for (int i = 0; i < r; i++) {
            rSumLib[rSum[i]]++;
        }
        for (int i = 0; i < c; i++) {
            cSumLib[cSum[i]]++;
        }
        long sum = 0;
        for (int i = 0; i <= k; i++) {
            sum += rSumLib[k - i] * cSumLib[i];
        }
        int over = 0;
        int shorter = 0;
        for (int i = 0; i < n; i++) {
            int t = rSum[rs[i]] + cSum[cs[i]];
            if (t == k) {
                over ++;
            } else if (t == k + 1) {
                shorter ++;
            }
        }
        // arrayDump(map);
        System.out.println(sum - over + shorter);
    }

    public static void arrayDump(int[][] a) {
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
        System.out.println("====");
    }
}
