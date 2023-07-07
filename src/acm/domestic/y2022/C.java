package acm.domestic.y2022;

import java.util.Scanner;

public class C {

    public static int h, w;
    public static int[][] a;
    public static int t;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) break;

            int ans = -m * m;

            for (int k = 1; k <= m; k++) {
                int mt = ((m / k) * (m / k) * (m - 1) + (m / k + m % k) * (m / k + m % k));
                int nt = (n - k - 1);
            }
            int m1 = (int) Math.floor((float) m / 2);
            int m2 = (int) Math.ceil((float) m / 2);
            System.out.println(m1);
            System.out.println(m2);


            System.out.println(ans);
//            1, 3, 5 -> 9
//            1, 3, 5 -> 9
//            1, 3 -> 4
//            1, 3, 5, 7 -> 16

//            1, 3, 5, 7, 9, 11, 13 -> 49
        }
    }
}
