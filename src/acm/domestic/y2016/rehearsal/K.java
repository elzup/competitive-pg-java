package acm.domestic.y2016.rehearsal;

import java.util.Scanner;

public class K {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);

        while (true) {
            double tmp = scanner.nextInt();
            double tmp2 = scanner.nextInt();;

            if (tmp == 0 && tmp2 == 0) {
                break;
            }

            System.out.println(tmp/tmp2);
        }
    }
}
