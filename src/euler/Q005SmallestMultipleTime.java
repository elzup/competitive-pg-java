package euler;

import java.util.ArrayList;

public class Q005SmallestMultipleTime {
    public static void main(String[] args) {
        long start, end;
        long N = 10000;

        start = System.currentTimeMillis();

        ArrayList<Integer> list = new ArrayList<>();

        for (int k = 1; k <= N; k++) {
            int i = k;
            for (int j : list) {
                if (i % j == 0) {
                    i /= j;
                }
            }
            if (i != 1) {
                list.add(i);
            }
        }

        end = System.currentTimeMillis();
        System.out.println((end - start)  + "ms");

        System.out.println("end");
    }
}
