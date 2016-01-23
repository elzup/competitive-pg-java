package atcoder.dwango2016;

import java.util.Scanner;

public class QbPencilTower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] k = new int[n - 1];
        String[] s = new String[n];
        for (int i = 0; i < n - 1; i++) {
            k[i] = sc.nextInt();
        }
        s[0] = String.valueOf(k[0]);
        for (int i = 0; i < n - 2; i++) {
            s[i + 1] = String.valueOf(Math.min(k[i], k[i + 1]));
        }
        s[n - 1] = String.valueOf(k[n - 2]);
        for (int i = 0; i < n - 1; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println(s[n - 1]);
    }
}

