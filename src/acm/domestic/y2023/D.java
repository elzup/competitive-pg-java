package acm.domestic.y2023;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            sc.nextLine();
            if (n == 0) break;
            String s = sc.nextLine();
            solve(n, s);
        }

    }

    private static void solve(int n, String s) {
        List<Integer> awards = new ArrayList<>();

        int k = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == 'o') {
                awards.add(i);
                k = k | i;
            }
        }
        int bi = Integer.bitCount(k);
        System.out.println(Integer.toBinaryString(k));
        System.out.println(bi);
        int remain = n - k;
        System.out.println(remain);
        bi += (remain | k) == k ? 0 : 1;

        System.out.println(bi);

    }


}
