package euler;

import java.util.ArrayList;

public class Q005SmallestMultiple {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int k = 1; k <= 20; k++) {
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

        int sum = 1;
        for (int i : list) {
            sum *= i;
        }
        System.out.println(sum);
    }
}
