package atcoder.arc.arc017;

import java.util.Scanner;

public class QbChainGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int chain = 1;
        int c = 0;
        if (k == 1)  {
            c ++;
        }
        for (int i = 1; i < n; i++) {
            if (a[i] <= a[i - 1]) {
                chain = 0;
            }
            chain ++;
            if (chain >= k) {
                // System.out.println(i);
                c ++;
            }
        }
        System.out.println(c);
    }
}
