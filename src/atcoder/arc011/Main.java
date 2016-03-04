package atcoder.arc011;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        // for (int i = 0; i < n; i++) {
        //     String w = sc.next();
        // }
        String res = line.toLowerCase()
                .replaceAll("[aeiouy,.]", "")
                .replaceAll("[bc]", "1")
                .replaceAll("[dw]", "2")
                .replaceAll("[tj]", "3")
                .replaceAll("[fq]", "4")
                .replaceAll("[lv]", "5")
                .replaceAll("[sx]", "6")
                .replaceAll("[pm]", "7")
                .replaceAll("[hk]", "8")
                .replaceAll("[ng]", "9")
                .replaceAll("[zr]", "0")
                .replaceAll("\\s{2,}", " ")
                .replaceAll("(^\\s|\\s$)", "");
        System.out.println(res);
    }
}


/*
3
Mozart plays magic.

7
I have a scissors for right hand.

4
abc ab aa aiueo

*/
