package atcoder.abc.abc029;

import java.util.Scanner;

public class QbContainsR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = 0;
        for (int i = 0; i < 12; i++) {
            String line = sc.nextLine();
            if (line.indexOf("r") != -1) {
                c ++;
            }
        }
        System.out.println(c);
    }
}
