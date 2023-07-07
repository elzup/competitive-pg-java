package acm.domestic.y2023;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            String s = sc.nextLine();
            solve(n, s);
        }

    }

    private static void solve(int n, String s) {
        List<List<Integer>> list = new ArrayList<>();
        sumComb(n, 0, 1, new ArrayList<>(), list);
        List<Integer> awards = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == 'o') {
                awards.add(i);
            }
        }
        for (List<Integer> l : list) {
            System.out.println(l);
        }
    }

    int knapsackDP(List<Integer> w, int[] v, int n, int W) {
        if (n <= 0 || W <= 0) {
            return 0;
        }

        int[][] m = new int[n + 1][W + 1];
        for (int j = 0; j <= W; j++) {
            m[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (w.get(i - 1) > j) {
                    m[i][j] = m[i - 1][j];
                } else {
                    m[i][j] = Math.max(
                            m[i - 1][j],
                            m[i - 1][j - w.get(i - 1)] + v[i - 1]);
                }
            }
        }
        return m[n][W];
    }

    private static void sumComb(int n, int used, int start, List<Integer> combination, List<List<Integer>> combinations) {
        if (used == n) {
            combinations.add(new ArrayList<>(combination));
        } else if (used < n) {
            for (int i = start; i <= n - used; i++) {
                combination.add(i);
                sumComb(n, used + i, i, combination, combinations);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
