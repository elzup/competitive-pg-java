package codeforces.round355.div2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long h = sc.nextLong();
        long k = sc.nextLong();
        long[] at = new long[n];
        for (int i = 0; i < n; i++) {
            at[i] = sc.nextInt();
        }
        Arrays.sort(at);
        ArrayList<Long> stack = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            stack.add(at[n - i - 1]);
        }

        long c = 0;
        long t = 0;
        while (!stack.isEmpty()) {
            // arrayDump(stack);
            for (int i = 0; i < stack.size(); i++) {
                long p = stack.get(i);
                if ((c + p) % k == 0) {
                    c += p;
                    stack.remove(i);
                    break;
                }
            }
            if (c % k != 0 || c == 0) {
                for (int i = 0; i < stack.size() && c < k; i++) {
                    long p = stack.get(i);
                    if (c + p <= h) {
                        c += p;
                        stack.remove(i);
                        i--;
                    }
                }
            }
            if (c <= k) {
                t++;
                c = 0;
            } else {
                t += c / k;
                c %= k;
            }
        }
        if (c != 0 && c <= k) {
            t++;
        }
        System.out.println(t);
    }

    public static void arrayDump(List<Integer> a) {
        for (int i = 0, l = a.size(); i < l; i++) {
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }
}
