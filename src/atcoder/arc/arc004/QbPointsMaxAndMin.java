package atcoder.arc.arc004;

import java.util.Scanner;

public class QbPointsMaxAndMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            max = Math.max(max, t);
            sum += t;
        }
        System.out.println(sum);
        System.out.println(Math.max(0, max * 2 - sum));
    }
}
