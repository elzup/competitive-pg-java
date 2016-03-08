package atcoder.arc016;

import java.util.Scanner;

public class QaWithoutCurrentAnswer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(n == m ? n - 1 : n);
    }
}
