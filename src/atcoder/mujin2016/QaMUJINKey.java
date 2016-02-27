package atcoder.mujin2016;

import java.util.Scanner;

public class QaMUJINKey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String c = sc.next();
        System.out.println("OPKL".indexOf(c) < 0 ? "Left" : "Right");
    }
}
