package acm.domestic.y2016.rehearsal;

import java.util.Scanner;

public class L {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String tmp = sc.nextLine();

            System.out.println(tmp.length());
        }
    }
}
