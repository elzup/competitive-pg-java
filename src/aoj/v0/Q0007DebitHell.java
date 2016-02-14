package aoj.v0;

import java.util.Scanner;

public class Q0007DebitHell {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // System.out.println(n);
        int k = 100000;
        for (int i = 0; i < n; i++) {
            k = 1000 * (int)Math.ceil(((double) k) * 1.05 / 1000);
        }
        System.out.println(k);
    }
}
