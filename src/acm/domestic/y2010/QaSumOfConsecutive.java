package acm.domestic.y2010;

import java.util.Scanner;

public class QaSumOfConsecutive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int c = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (consum(i, j) == n) {
                        c ++;
                    }
                }
            }
            System.out.println(c);
        }
    }

    public static int consum(int a, int b) {
        return (b * (b + 1) - a * (a + 1))/ 2;
    }
}
