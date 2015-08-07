package paiza;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A008CompParade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> check = new HashMap<>();
        int N = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 0; i < N; i++) {
            check.put(i, 0);
        }
        int[] ds = new int[M];
        for (int i = 0; i < M; i++) {
            ds[i] = sc.nextInt() - 1;
        }

        // arrayDump(ds);
        int si = 0;
        int ei = -1;
        check.put(ds[si], 1);
        int min = Integer.MAX_VALUE;
        while (true) {
            // mapDump(check);
            boolean isAligned = ! contains0(check);
            // System.out.println(ei + "::" + si);
            // System.out.println(isAligned);
            if (si < M - 1 && !isAligned) {
                // System.out.println("+");
                si ++;
                check.put(ds[si], check.get(ds[si]) + 1);
            } else if (isAligned) {
                // System.out.println("-");
                min = Math.min(min, si - ei);
                ei ++;
                check.put(ds[ei], check.get(ds[ei]) - 1);
            } else {
                break;
            }
        }
        System.out.println(min);
    }

    public static void arrayDump(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void mapDump(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    public static boolean contains0(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            if (e.getValue() == 0) {
                return true;
            }
        }
        return false;
    }
}
