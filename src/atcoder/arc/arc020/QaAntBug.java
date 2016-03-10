package atcoder.arc.arc020;

import java.util.Scanner;

public class QaAntBug {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Math.abs(sc.nextInt());
        int b = Math.abs(sc.nextInt());
        System.out.println(new String[]{ "Ant", "Draw", "Bug"}[Integer.compare(a, b) + 1]);
    }
}
