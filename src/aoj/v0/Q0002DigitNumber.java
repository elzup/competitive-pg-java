package aoj.v0;

import java.util.Scanner;

public class Q0002DigitNumber {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        while(sn.hasNext()) {
            int a = sn.nextInt();
            int b = sn.nextInt();
            int k = a + b;
            System.out.println((k + "").length());
        }
    }
}
