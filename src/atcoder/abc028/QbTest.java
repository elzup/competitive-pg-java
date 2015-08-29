package atcoder.abc028;

import java.util.Scanner;

public class QbTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int[] res = new int[6];
        for (int i = 0; i < line.length(); i++) {
            res[(int)line.charAt(i) - 65] ++;
        }
        System.out.println(
                String.valueOf(res[0]) + " " +
                        String.valueOf(res[1]) + " " +
                        String.valueOf(res[2]) + " " +
                        String.valueOf(res[3]) + " " +
                        String.valueOf(res[4]) + " " +
                        String.valueOf(res[5]));
    }
}

