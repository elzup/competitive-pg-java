package atcoder.arc.arc054;

import java.util.Scanner;

public class Main2 {
    static double p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        p = sc.nextDouble();
        // System.out.println(p);
        double l = 0;
        double r = p;
        double c = p / 2;
        double min = time(c);
        for (int i = 0; i < 1000 && l != r; i++) {
            // System.out.println(min);
            double lp = l + (c - l) / 2;
            double rp = c + (r - c) / 2;
            double lt = time(lp);
            double rt = time(rp);
            if (lt < rt) {
                r = c;
                min = lt;
                c = lp;
            } else {
                l = c;
                min = rt;
                c = rp;
            }
        }
        System.out.println(min);
    }

    public static double time(double start) {
        return p / (Math.pow(2, start * 2 / 3)) + start;
    }

}
