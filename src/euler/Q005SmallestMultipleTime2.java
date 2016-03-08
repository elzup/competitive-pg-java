package euler;

import java.util.ArrayList;

public class Q005SmallestMultipleTime2 {
    public static void main(String[] args) {
        long start, end;
        long N = 10000;

        start = System.currentTimeMillis();

        ArrayList<Integer> list2 = new ArrayList<>();
        for (int k = 1; k <= N; k++) {
            if (isPrime(k)) {
                list2.add(k);
            }
        }
        for (int i : list2) {
            int t = 1;
            while (t * i < N) {
                t *= i;
            }
        }

        end = System.currentTimeMillis();
        System.out.println((end - start)  + "ms");

        System.out.println("end");
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        int k = (int) Math.floor(Math.sqrt(n));
        for (int i = 3; i < k; i += 2) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }
}
