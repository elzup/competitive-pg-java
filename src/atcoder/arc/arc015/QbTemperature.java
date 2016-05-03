package atcoder.arc.arc015;

import java.util.Scanner;

public class QbTemperature {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;
        for (int i = 0; i < n; i++) {
            float up = sc.nextFloat();
            float down = sc.nextFloat();
            if (up >= 35) {
                a ++;
            } else if (up >= 30) {
                b ++;
            } else if (up >= 25) {
                c ++;
            }
            if (down >= 25) {
                d ++;
            }
            if (down < 0 && up >= 0) {
                e ++;
            } else if (up < 0) {
                f ++;
            }
        }
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f);
    }
}
