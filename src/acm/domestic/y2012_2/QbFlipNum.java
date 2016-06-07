package acm.domestic.y2012_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QbFlipNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println(next(83268, 6));
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int l = sc.nextInt();
            if ((a | l) == 0) {
                break;
            }
            ArrayList<Integer> list = new ArrayList<>();
            list.add(a);
            while (true) {
                // System.out.println((list.size() - 1) + ": " + a);
                a = next(a, l);
                if (list.contains(a)) {
                    break;
                }
                list.add(a);
            }
            int j = list.size();
            int i = list.indexOf(a);
            System.out.println(i + " " + list.get(i) + " " + (j - i));
        }
    }

    public static int next(int n, int k) {
        String sn = String.valueOf(n);
        int[] ns = new int[k];
        for (int i = 0; i < sn.length(); i++) {
            ns[i] = Integer.parseInt("" + sn.charAt(i));
        }
        Arrays.sort(ns);
        String upN = "";
        String downN = "";
        for (int i = 0, l = ns.length; i < l; i++) {
            downN += ns[i];
            upN += ns[l - i - 1];
        }
        // System.out.println("u: " + upN);
        // System.out.println("d: " + downN);
        return Integer.parseInt(upN) - Integer.parseInt(downN);
    }
}
