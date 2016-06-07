package acm.domestic.y2008;

import java.util.Scanner;

public class QaEqualTotalScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if ((n | m) == 0) {
                break;
            }
            int[] a = new int[n];
            int[] b = new int[m];
            int as = 0, bs = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                as += a[i];
            }
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
                bs += b[i];
            }

            int ar = 1000;
            int br = 1000;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int d = a[i] - b[j];
                    if (as - d == bs + d && ar + br > a[i] + b[j]) {
                        ar = a[i];
                        br = b[j];
                    }
                }
            }
            System.out.println(ar + br == 2000 ? -1 : (ar + " " + br));
        }

    }
}
