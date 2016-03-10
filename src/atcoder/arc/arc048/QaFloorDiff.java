package atcoder.arc.arc048;

import java.util.Scanner;

public class QaFloorDiff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        if (a < 0) {
            a ++;
        }
        if (b < 0) {
            b ++;
        }
        System.out.println(b - a);
    }
}
