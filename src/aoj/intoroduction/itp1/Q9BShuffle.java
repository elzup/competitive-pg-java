package aoj.intoroduction.itp1;

import java.util.Scanner;

public class Q9BShuffle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            if ("-".equals(str)) {
                break;
            }
            int m = sc.nextInt();
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += sc.nextInt();
            }
            int bi = sum % str.length();
            int ei = bi + str.length();
            String res = (str + str).substring(bi, ei);
            System.out.println(res);
            sc.nextLine();
        }
    }
}
