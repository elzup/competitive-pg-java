package aoj.intoroduction.itp1;

import java.util.Scanner;

public class Q9CCardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        int pa = 0;
        int pb = 0;
        for (int i = 0; i < n; i++) {
            String[] words = sc.nextLine().split(" ");
            int c = words[0].compareTo(words[1]);
            if (c == 0) {
                pa++;
                pb++;
            } else if (c > 0) {
                pa += 3;
            } else {
                pb += 3;
            }
        }
        System.out.println(pa + " " + pb);
    }
}
