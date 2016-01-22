package atcoder.abc018;

import java.util.Scanner;

public class QcDiaPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();
        int kf = k * 2 - 1;
        sc.nextLine();
        String[] lines = new String[r];
        for (int i = 0; i < r; i++) {
            lines[i] = sc.nextLine();
        }

        int[][] points = new int[r][c];
        for (int j = 0; j < r; j++) {
            int left = 0;
            int right = 0;
            int[][] pp = new int[c][2];
            for (int i = 0; i < c; i++) {
                int ir = c - i - 1;
                if (lines[j].charAt(i) == 'o') {
                    left += 1;
                } else {
                    left = 0;
                }
                if (lines[j].charAt(ir) == 'o') {
                    right += 1;
                } else {
                    right = 0;
                }
                pp[i][0] = left;
                pp[ir][1] = right;
            }
            for (int i = 0; i < c; i++) {
                points[j][i] = Math.min(pp[i][0], pp[i][1]);
            }
        }

        // arrayDump(points);
        int sum = 0;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j <= r - kf; j++) {
                boolean ck = true;
                for (int l = 0; l < (kf + 1) / 2 && ck; l++) {
                    // System.out.println((j + l) + ":" + (j + kf - l - 1));
                    if (points[j + l][i] < l + 1 || points[j + kf - l - 1][i] < l + 1) {
                        ck = false;
                    }
                }
                // System.out.println(ck + "--");
                if (ck) {
                    sum += 1;
                }
            }
            // System.out.println("==");
        }
        System.out.println(sum);
    }

    public static void arrayDump(int[][] k) {
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                System.out.print("[" + k[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println("---");
    }
}
