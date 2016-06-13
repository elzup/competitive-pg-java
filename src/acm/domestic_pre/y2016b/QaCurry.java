package acm.domestic_pre.y2016b;

import java.util.Scanner;

public class QaCurry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int r0 = sc.nextInt();
            int w0 = sc.nextInt();
            int c = sc.nextInt();
            int r = sc.nextInt();
            if ((r0 | w0 | c | r) == 0) {
                break;
            }
            int k = w0 * c;
            int i = 0;
            while (r0 < k) {
                i++;
                r0 += r;
            }
            System.out.println(i);
        }
    }
}
