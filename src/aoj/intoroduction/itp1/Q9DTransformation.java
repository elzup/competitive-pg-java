package aoj.intoroduction.itp1;

import java.util.Scanner;

public class Q9DTransformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] ops = sc.nextLine().split(" ");
            int v1 = Integer.parseInt(ops[1]);
            int v2 = Integer.parseInt(ops[2]);
            String k = word.substring(v1, v2 + 1);
            if ("print".equals(ops[0])) {
                System.out.println(k);
            } else if ("reverse".equals(ops[0])) {
                word = word.substring(0, v1) + new StringBuilder(k).reverse().toString() + word.substring(v2 + 1);
            } else if ("replace".equals(ops[0])) {
                word = word.substring(0, v1) + ops[3] + word.substring(v2 + 1);
            }
            // System.out.println(word);
        }
    }
}
