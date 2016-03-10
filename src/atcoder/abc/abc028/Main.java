package atcoder.abc.abc028;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println((double)(((K - 1) * (N - K) * 6 + (N - 1) * 3) + 1) / (N * N * N));
    }
}
