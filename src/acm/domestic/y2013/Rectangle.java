package acm.domestic.y2013;

import java.util.Scanner;

public class Rectangle {
    static Scanner sc;

    final static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        while (true) {
            int h = sn();
            int w = sn();
            if ((w | h) == 0) {
                break;
            }
            solve2(w, h);
        }
    }

    public static void solve(int w, int h) {
        int rr = rr(w, h);
        int min = INF;
        int minh = h, minw = w;
        for (int i = 1; i <= 150; i++) {
            for (int j = i + 1; j <= 150; j++) {
                int rr2 = rr(i, j);
                if ((h == i && w == j) || rr > rr2) {
                    continue;
                }
                if (min > rr2 || (min == rr2)) {
                    if (min == rr2) {
                        System.out.println(i + " " + j);
                        return;
                    }
                    min = rr2;
                    minh = i;
                    minw = j;
                }
            }
        }
        System.out.println(minh + " " + minw);
    }


    public static void solve2(int w, int h) {
        int rr = rr(w, h);
        for (int h1 = h + 1; h1 <= 150; h1++) {
            for (int w1 = h1 + 1; w1 <= 150; w1++) {
                if (rr(h1, w1) == rr) {
                    System.out.println(h1 + " " + w1);
                    return;
                }
            }
        }

        for (int rr2 = rr + 1, l = 150 * 150; rr2 <= l; rr2++) {
            for (int h1 = 1; h1 < rr2; h1++) {
                double h2 = Math.sqrt(h1);
                double w2 = Math.sqrt(Math.floor(rr2) - h1);
                if (isInt(h2) && isInt(w2) && (h2 != w2)) {
                    System.out.println((int)h2 + " " + (int)w2);
                    return;
                }
            }
        }

    }
    public static boolean isInt(double n) {
        return n == Math.floor(n);
    }

    public static int rr(int w, int h) {
        return w * w + h * h;
    }

    public static int sn() {
        return sc.nextInt();
    }
}

