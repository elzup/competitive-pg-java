package atcoder.arc.arc007;

import java.util.Scanner;

public class QaTrim {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String X = sc.next();
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            String sp = s.charAt(i) + "";
            if (!X.equals(sp)) {
                System.out.print(sp);
            }
        }
        System.out.println();
    }
}
