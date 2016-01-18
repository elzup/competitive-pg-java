package atcoder.abc005;

import java.util.Scanner;

public class QcBuy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int[] tla = new int[100];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt() - 1;
            tla[a] += 1;
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int b = sc.nextInt() - 1;
            boolean eat = false;
            // System.out.println(b);
            for (int j = Math.max(0, b - t); j < b + 1; j++) {
                // System.out.println(":" + j);
                if (tla[j] > 0) {
                    tla[j] -= 1;
                    eat = true;
                    break;
                }
            }
            if (!eat) {
                System.out.println("no");
                return;
            }
        }

        System.out.println("yes");
    }
}
