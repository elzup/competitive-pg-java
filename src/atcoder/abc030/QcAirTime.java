package atcoder.abc030;

import java.util.Scanner;

public class QcAirTime {

    public static int ia = 0;
    public static int ib = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        int s = a[0] + x;
        int c = 0;
        // System.out.println(s + ", " + c);
        while(true) {
            int is = ib = next(b, s, ib);
            if (is == -1) {
                break;
            }
            c ++;
            s = b[is] + y;
            // System.out.println("b" + s + ", " + c);
            is = ia = next(a, s, ia);
            if (is == -1) {
                break;
            }
            s = a[is] + x;
            // System.out.println("a" + s + ", " + c);
        }
        System.out.println(c);
    }

    public static int next(int[] a, int t, int start) {
        int down = start;
        int up = a.length - 1;
        if (a[a.length - 1] < t) {
            return -1;
        }
        // if (a[0] >= t) {
        //     return 0;
        // }
        while(up - down > 0) {
            int p = down + (up - down) / 2;
            if (a[p] >= t) {
                up = p;
            } else {
                down = p + 1;
            }
        }
        return down;
    }
}
