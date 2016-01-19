package atcoder.abc004;

import java.util.Scanner;

public class Main {
    final static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        int tmax = 900 - r + g + b;
        int min = INF;
        for (int t1 = 0; t1 < tmax; t1++) {
            for (int t2 = 0; t2 < tmax - t2; t2++) {
                int rs = 0;
                int re = rs + r;
                int gs = re + 1 + t1;
                int ge = gs + g;
                int bs = ge + 1 + t2;
                int be = bs + b;
                min = Math.min(min, count(rs, re, gs, ge, bs, be));
                // System.out.println(rs + ":" + re + ":" + gs + ":" + ge + ":" + bs + ":" + be);
            }
        }
        System.out.println(min);
    }

    public static int count(int rs, int re, int gs, int ge, int bs, int be) {
        int i = 0;
        int r = re - rs;
        int g = ge - gs;
        int b = be - bs;
        int cmin = INF;
        while(i + 200 < be) {
            int c = 0;
            c += count_mt(r, rs + i);
            c += count_mt(g, gs + i);
            c += count_mt(b, bs + i);
            i += 1;
            cmin = Math.min(cmin, c);
        }
        return cmin;
    }

    public static int count_mt(int l, int o) {
        if (o >= l) {
            o = l - o;
        }
        if (o <= 0) {
            int s = 0 - o;
            int e = l - 1 - o;
            return (e * (e + 1) / 2) - (s * (s - 1) / 2);
        }
        int k = (l - 1) - o;
        return (k * (k + 1) / 2) + (o * (o + 1) / 2);
    }
}
