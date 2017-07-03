package atcoder.arc.arc021;

import java.util.Scanner;

public class QbXor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
            t ^= b[i];
        }
        if (t != 0) {
            System.out.println(-1);
            System.exit(0);
        }
        a[0] = 0;
        System.out.println(0);
        for (int i = 0; i < b.length - 1; i++) {
            a[i + 1] = a[i] ^ b[i];
            System.out.println(a[i + 1]);
        }
    }
}
