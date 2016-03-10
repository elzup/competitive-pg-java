package atcoder.arc.arc020;

import java.util.Scanner;

public class QbStripe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        int s_min = Integer.MAX_VALUE;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (i == j) {
                    continue;
                }
                int s = 0;
                for (int k = 0; k < n; k += 2) {
                    if (a[k] != i) {
                        s ++;
                    }
                }
                for (int k = 1; k < n; k += 2) {
                    if (a[k] != j) {
                        s ++;
                    }
                }
                s_min = Math.min(s, s_min);
            }
        }
        System.out.println(s_min * c);
    }
}

