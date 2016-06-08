package codeforces.round356.div2;

import java.util.Scanner;

public class QaCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }

        int max = 0;
        for (int b: a) {
            int k = 0;
            for (int c: a) {
                if (b == c) {
                    k ++;
                }
            }
            if (k >= 2) {
                max = Math.max(Math.min(3, k) * b, max);
            }
        }
        System.out.println(sum - max);
    }
}
