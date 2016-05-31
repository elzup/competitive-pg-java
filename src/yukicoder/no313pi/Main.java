package yukicoder.no313pi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int[] lib = new int[]{ 20104, 20063, 19892, 20011, 19874, 20199, 19898, 20163, 19956, 19841 };
        int[] counts = new int[10];
        for (int i = 0; i < 200002; i++) {
            char c = input.charAt(i);
            if (c == '.') {
                continue;
            }
            counts[Integer.valueOf("" + c)] ++;
            // System.out.println(input.charAt(i));
        }
        int dummy = -1, piero = -1;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > lib[i]) {
                dummy = i;
            }
            if (counts[i] < lib[i]) {
                piero = i;
            }
        }
        System.out.println(dummy + " " + piero);
    }
}
