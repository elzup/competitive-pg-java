package atcoder.arc011;

import java.util.Scanner;

public class QaSuperPencil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int buy = sc.nextInt();
        int sum = buy;
        int least = 0;
        int num = buy + least;
        while (num >= m) {
            // System.out.println("buy:   " + buy);
            // System.out.println("least: " + least);
            // System.out.println("sum:   " + sum);
            // System.out.println("num:   " + num);
            buy = (num / m) * n;
            least = num % m;
            sum += buy;
            num = buy + least;
        }
        System.out.println(sum);
    }
}
