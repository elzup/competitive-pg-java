package acm.domestic.y2004;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static double[][] circles;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            circles = new double[n][2];
            for (int i = 0; i < n; i++) {
                circles[i][0] = sc.nextDouble();
                circles[i][1] = sc.nextDouble();
            }
            ArrayList<Double[]> points = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    double d = oDistance(i, j) / 2;
                    if (d > 1.0) {
                        continue;
                    }
                    double cx = (circles[i][0] + circles[j][0]) / 2;
                    double cy = (circles[i][1] + circles[j][1]) / 2;
                    double s = Math.sqrt(1 - d * d);
                    double theta = theta(i, j);
                    points.add(new Double[]{cx - Math.sin(theta) * s, cy + Math.cos(theta) * s});
                    points.add(new Double[]{cx + Math.sin(theta) * s, cy - Math.cos(theta) * s});

                }
            }
            int max = 0;
            for (int i = 0; i < points.size(); i++) {
                Double[] p = points.get(i);
                int c = 0;
                for (int j = 0; j < n; j++) {
                    if (isIn(p[0], p[1], j)) {
                        c++;
                    }
                }
                max = Math.max(max, c);
            }
            System.out.println(max);
        }
    }

    public static boolean isIn(double x, double y, int n) {
        return Math.pow(x - circles[n][0], 2.0) + Math.pow(y - circles[n][1], 2.0) <= 1.0;
    }

    public static double oDistance(int n1, int n2) {
        return Math.sqrt(Math.pow(circles[n2][0] - circles[n1][0], 2.0) + Math.pow(circles[n2][1] - circles[n1][1], 2.0));
    }

    public static double theta(int n1, int n2) {
        return Math.atan((circles[n1][1] - circles[n2][1]) / (circles[n1][0] - circles[n2][0]));
    }
}
