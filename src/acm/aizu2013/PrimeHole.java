package acm.aizu2013;

import java.util.Scanner;

public class PrimeHole {
    static Scanner sc;

    final static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        while (true) {
            int m = sn();
            int n = sn();
            if ((m | n) == 0) {
                break;
            }
            int l = (int) Math.ceil(Math.sqrt(m));
            int[][] map = createMap(m, l);
            int[][] pmap = new int[l][l];
            int[][] rmap = new int[l][l];
            boolean st = false;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    pmap[i][j] = -1;
                    rmap[i][j] = -1;
                }
            }
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    if (map[i][j] == n && !st) {
                        pmap[i][j] = 0;
                        rmap[i][j] = 0;
                        if (isPrime(n)) {
                            pmap[i][j] = 1;
                            rmap[i][j] = map[i][j];
                        }
                        st = true;
                    }
                    if (i < l - 1 && pmap[i][j] != -1) {
                        for (int k = Math.max(0, j - 1); k <= Math.min(l - 1, j + 1); k++) {
                            if (pmap[i + 1][k] == -1) {
                                pmap[i + 1][k] = pmap[i][j];
                                rmap[i + 1][k] = rmap[i][j];
                                if (isPrime(map[i + 1][k])) {
                                    pmap[i + 1][k] ++;
                                    rmap[i + 1][k] = map[i + 1][k];
                                }
                            } else {
                                int pp = pmap[i + 1][k];
                                int np = pmap[i][j] + (isPrime(map[i + 1][k]) ? 1 : 0);
                                if (pp < np) {
                                    pmap[i + 1][k] = np;
                                    rmap[i + 1][k] = rmap[i][j];
                                    if (isPrime(map[i + 1][k])) {
                                        rmap[i + 1][k] = map[i + 1][k];
                                    }
                                } else if (pp == np && !isPrime(map[i + 1][k])) {
                                    rmap[i + 1][k] = Math.max(rmap[i + 1][k], rmap[i][j]);
                                }
                            }
                        }
                    }
                }
            }
            // dumpArray(map);
            // dumpArrayPrime(map);
            // dumpArray(pmap);
            // dumpArray(rmap);
            int max = 0;
            int maxi = 0;
            for (int i = 0; i < l; i++) {
                if (pmap[l - 1][i] == -1 || pmap[l - 1][i] < max) {
                    continue;
                }
                if (max < pmap[l - 1][i]) {
                    maxi = rmap[l - 1][i];
                } else if (max == pmap[l - 1][i]) {
                    maxi = Math.max(maxi, rmap[l - 1][i]);
                }
                max = pmap[l - 1][i];
            }
            System.out.println(max + " " + maxi);
        }
    }

    public static int[][] createMap(int n, int l) {
        int[][] map = new int[l][l];
        int[][] vec = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        int k = 0;
        int i = 1;
        int gen = 2;
        int[] pos = new int[2];
        if (l % 2 == 0) {
            pos[0] = l / 2 - 1;
            pos[1] = l / 2;
        } else {
            pos[0] = (l - 1) / 2;
            pos[1] = (l - 1) / 2;
        }
        while (true) {
            map[pos[1]][pos[0]] = i;
            pos[0] += vec[(gen + 2) % 4][0];
            pos[1] += vec[(gen + 2) % 4][1];
            if (i == n) {
                break;
            }
            i++;
            k++;
            if (k == Math.floor(gen / 2)) {
                k = 0;
                gen++;
            }
        }
        return map;
    }

    public static void dumpArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(String.format("%3d, ", arr[i][j]));
            }
            System.out.println();
        }
        System.out.println("---");
    }

    public static void dumpArrayPrime(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print((isPrime(arr[i][j]) ? "pr" : " _") + ", ");
            }
            System.out.println();
        }
        System.out.println("---");
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n % 2 == 0) {
            return n == 2;
        }
        for (int i = 3, l = (int) Math.floor(Math.sqrt(n)); i <= l; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int sn() {
        return sc.nextInt();
    }
}
