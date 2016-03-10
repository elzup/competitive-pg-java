package atcoder.arc.arc011;

import java.util.Scanner;

public class QaSuperPencilFanctional {
    public static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int num = sc.nextInt();
        System.out.println(sell(num) + num);
    }

    public static int sell(int num) {
        if (num < m) {
            return 0;
        }
        int least = num % m;
        int sold = (num / m) * n;
        return sold + sell(sold + least);
    }
}
