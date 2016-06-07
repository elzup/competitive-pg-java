package acm.domestic.y2012_2;

import java.util.Scanner;

public class QaMireum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int y = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();
            int c = 0;
            while (true) {
                c++;
                d++;
                if (((y % 3 == 0 || m % 2 == 1) && d > 20) ||
                        (y % 3 != 0 && m % 2 == 0 && d > 19)) {
                    m++;
                    d = 1;
                }
                if (m > 10) {
                    y ++;
                    m = 1;
                }
                if (y == 1000) {
                    break;
                }
            }
            System.out.println(c);
        }
    }
}
