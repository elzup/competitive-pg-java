package atcoder.arc018;

import java.util.Scanner;

public class QbMatrixTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        int c = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    long ax = points[i][0];
                    long ay = points[i][1];
                    long bx = points[j][0];
                    long by = points[j][1];
                    long cx = points[k][0];
                    long cy = points[k][1];
                    long s = Math.abs((ax - cx) * (by - cy) - ((ay - cy) * (bx - cx)));
                    // System.out.println(s);
                    if (s != 0 && s % 2 == 0) {
                        c ++;
                    }
                }
            }
        }
        System.out.println(c);
    }
}
