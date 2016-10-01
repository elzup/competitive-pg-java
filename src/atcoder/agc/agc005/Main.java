package atcoder.agc.agc005;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }
        for (int d = 1; d < n; d++) {
            int[] b = new int[n - d];
            for (int i = 0; i < n - d; i++) {
                b[i] = Math.min(a[i], a[i + 1]);
                sum += b[i];
            }
            a = b;
        }
        System.out.println(sum);
    }
}
