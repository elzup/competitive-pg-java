package aoj.intoroduction.itp1;

import java.util.Scanner;

public class Q10ADistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        System.out.println(distance(x1, y1, x2, y2));
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        double d1 = x1 - x2;
        double d2 = y1 - y2;
        return Math.sqrt(d1 * d1 + d2 * d2);
    }
}
