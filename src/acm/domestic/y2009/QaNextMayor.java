package acm.domestic.y2009;

import java.util.Scanner;

public class QaNextMayor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            if ((n | p) == 0) {
                break;
            }
            int w = p;
            int t = 0;
            int[] s = new int[n];
            while (true) {
                if (w == 0) {
                    w = s[t % n];
                    s[t % n] = 0;
                } else {
                    s[t % n]++;
                    w--;
                }
                if (w == p) {
                    break;
                }
                t ++;
            }
            System.out.println(t % n);
        }
    }
}
