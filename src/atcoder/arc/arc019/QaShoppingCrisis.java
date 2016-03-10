package atcoder.arc.arc019;

import java.util.Scanner;

public class QaShoppingCrisis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        s = s.replaceAll("O", "0")
                .replaceAll("D", "0")
                .replaceAll("I", "1")
                .replaceAll("Z", "2")
                .replaceAll("S", "5")
                .replaceAll("B", "8");
        System.out.println(Integer.valueOf(s));
    }
}
