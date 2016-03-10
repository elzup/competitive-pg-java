package atcoder.abc.abc032;

import java.util.Arrays;
import java.util.Scanner;

public class QbPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        String[] keys;
        try {
            keys = new String[s.length() - k + 1];
        } catch (NegativeArraySizeException e) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < s.length() - k + 1; i++) {
            keys[i] = s.substring(i, i + k);
        }
        System.out.println(Arrays.stream(keys).distinct().count());
    }
}
