package atcoder.abc030;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = sc.nextInt() - 1;

        BigInteger k = new BigInteger(sc.next());
        int[] b = new int[N];
        int[] bc = new int[N];
        for (int i = 0; i < N; i++) {
            b[i] = sc.nextInt() - 1;
        }
        long t = 0;
        boolean r = true;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(k) < 0; i = i.add(BigInteger.ONE)) {
            // System.out.println(a);
            // arrayDump(bc);
            bc[a] += 1;
            a = b[a];
            if (bc[a] == 2) {
                t += 1;
            } else if (bc[a] == 3 && r) {
                r = false;
                // System.out.println("t: " + t);
                // System.out.println("s: " + k.subtract(i));
                k = k.subtract(i).mod(BigInteger.valueOf(t));
                // System.out.println("mod: " + k);
                i = BigInteger.ZERO;
            }
        }
        System.out.println(a + 1);
    }

    public static void arrayDump(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }
}

/*
6 4
3005
2 3 1 2 6 5

6 4
300000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000005
2 3 1 2 6 5

4 1
0
2 3 4 1

*/
