package acm.domestic.y2016.rehearsal;

import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ans = 0;
        while (true) {
            int tmp = sc.nextInt();

            if (tmp == 0)
                break;

            if (ans < tmp) {
                ans = tmp;
            }
        }
        System.out.println(ans);
    }
}
