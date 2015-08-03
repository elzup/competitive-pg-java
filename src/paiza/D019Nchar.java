package paiza;

import java.util.Scanner;

public class D019Nchar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ws = sc.nextLine().split(" ");
        String word = ws[0];
        int n = Integer.parseInt(ws[1]);
        System.out.println(word.charAt(n - 1));
    }
}
