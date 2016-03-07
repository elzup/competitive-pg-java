package atcoder.arc012;

import java.util.Scanner;

public class QbTurtleDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double va = sc.nextInt();
        int vb = sc.nextInt();
        int L = sc.nextInt();

        double k = L;
        for (int i = 0; i < N; i++) {
            k = k * vb / va;
            // System.out.println(k);
        }
        System.out.printf("%.8f\n", k);
    }
}
