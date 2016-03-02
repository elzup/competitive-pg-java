package atcoder.arc008;

import java.util.Scanner;

public class QaOctopusDumplingPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pack = (n / 10);
        int least = n % 10;
        if (least >= 7) {
            least = 0;
            pack ++;
        }
        System.out.println(pack * 100 + least * 15);
    }
}
