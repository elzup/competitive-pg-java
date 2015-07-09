package aoj.v0;

import java.util.Scanner;

public class Q0004SimultaneousEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double e = sc.nextDouble();
            double c = sc.nextDouble();
            double d = sc.nextDouble();
            double f = sc.nextDouble();
            double[] res = simultaneousEquation(a, b, c, d, e, f);
            System.out.printf("%.3f %.3f\n", res[0], res[1]);
        }
    }

    public static double[] simultaneousEquation(double a, double b, double c, double d, double e, double f) {
        double t = a * d - c * b;
        double x = (d * e - b * f) / t;
        double y = (a * f - c * e) / t;
        x += 0.0f;
        y += 0.0f;
        return new double[]{ x, y };
    }
}
