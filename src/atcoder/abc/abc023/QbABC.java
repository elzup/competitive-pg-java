package atcoder.abc.abc023;

import java.util.Scanner;

public class QbABC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int step = (n - 1) / 2;
        // System.out.println("step: " + step);
        System.out.println(s.equals(ans(step)) ? step : -1);
        // for (int i = 1; i < 101; i++) {
        //     System.out.println(i + ": " + ans(i));
        // }
    }

    public static String ans(int step) {
        if (step % 3 == 0) {
            return strRepeat("bca", (step / 3) * 2) + "b";
        } else if (step % 3 == 1) {
            return strRepeat("abc", (step / 3) * 2 + 1);
        }
        return strRepeat("cab", (step / 3) * 2 + 1) + "ca";
    }

    public static String strRepeat(String s, int n) {
        return new String(new char[n]).replace("\0", s);
    }
}

/*

0
b

1
abc "abc" * 1

2
cab ca

3
bca bca b

4
abc abc abc "abc" * 3

5
cab cab cab ca

6
bca bca bca bca b

7
abc abc abc abc abc "abc" * 5
8
9

 */
