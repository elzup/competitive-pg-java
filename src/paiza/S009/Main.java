package paiza.S009;

import java.util.Scanner;

public class Main {

    public static int m;
    public static int n;
    public static int[] min;
    public static int[][] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] base = new int[n];
        for (int i = 0; i < n; i++) {
            base[i] = sc.nextInt();
        }
        m = sc.nextInt();

        p = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = sc.nextInt();
            }
        }
        min = base.clone();
        int[] t = new int[m];
        int[] ck = new int[m];
        for (int i = 0; i < m; i++) {
            t[i] = -1;
            ck[i] = i;
        }
        perm(t, ck, m - 1, base);
        for (int i = 0; i < n; i++) {
            System.out.print(min[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void perm(int[] t, int[] ck, int k, int[] base) {
        // System.out.print("t: ");
        // arrayDump(t);
        // System.out.print("b: ");
        // arrayDump(base);
        // System.out.print("m: ");
        // arrayDump(min);
        // System.out.println("---");
        min = min(min, base);
        if (k < 0) {
            return ;
        }
        for (int i = 0; i < ck.length; i++) {
            if (ck[i] != -1) {
                int[] ckt = ck.clone();
                ckt[i] = -1;
                t[m - k - 1] = ck[i];
                int[] bt = next(base, p[ck[i]]);
                perm(t, ckt, k - 1, bt);
                t[m - k - 1] = -1;
            }
        }
    }

    public static int[] next(int[] base, int[] p) {
        // System.out.println("next{}");
        // System.out.print("base:");
        // arrayDump(base);
        // System.out.print("p:");
        // arrayDump(p);
        int[] tmp = new int[base.length];
        for (int i = 0; i < base.length; i++) {
            tmp[p[i] - 1] = base[i];
        }
        // System.out.print("res:");
        // arrayDump(tmp);
        return tmp;
    }

    public static void arrayDump(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == -1) {
                continue;
            }
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static int compareArray(int[] a, int [] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }
        return 0;
    }

    public static int[] min(int[] a, int [] b) {
        if (compareArray(a, b) < 0) {
            return a;
        }
        return b;
    }
}
