package acm.domestic.y2014_2;

import java.util.Scanner;

public class QaPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int s = sc.nextInt();
            if ((x | y | s) == 0) {
                break;
            }
            System.out.println(solve(x, y, s));
        }
    }

    public static int solve(int x, int y, int s) {
        int max = 0;
        for (int i = 1; i < s; i++) {
            for (int j = 1; j < s; j++) {
                int t1 = ((x + 100) * i) / 100;
                int t2 = ((x + 100) * j) / 100;
                int pre = t1 + t2;
                if (pre != s) {
                    continue;
                }
                t1 = ((y + 100) * i) / 100;
                t2 = ((y + 100) * j) / 100;
                max = Math.max(max, t1 + t2);
            }
        }
        return max;
    }
}
