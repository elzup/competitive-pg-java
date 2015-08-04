package template;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Utils {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println("> " + i);
            int[] p1 = spiralPos(i);
            System.out.println(p1[0] + ", " + p1[1]);
            System.out.println();
        }
    }

    public static long comb(int a, int b) {
        long[] k = new long[a / 2 + 1];
        long[] pre = new long[a / 2 + 1];
        pre[0] = 1;
        for (int i = 1; i <= a; i++) {
            k[0] = 1;
            for (int j = 1, lj = i / 2; j <= lj; j++) {
                if (j == lj) {
                    k[j] = (i % 2 == 0) ? pre[j - 1] * 2 : pre[j - 1] + pre[j];
                    break;
                }
                k[j] = (pre[j] + pre[j - 1]);
            }
            pre = k.clone();
        }
        return pre[Math.min(b, a - b)];
    }

    public static <T> void arrayDump(T[][] k) {
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                System.out.print(k[i][j].toString() + " ");
            }
            System.out.println();
        }
        System.out.println("---");
    }

    public static <T> void arrayDump(T[] k) {
        for (int i = 0; i < k.length; i++) {
            System.out.print(k[i].toString() + " ");
        }
    }

    public static void arrayDump(long[] k) {
        for (int i = 0; i < k.length; i++) {
            System.out.print(String.format("%5d", k[i]));
        }
    }

    public static int[][] arrayCopy(int[][] k) {
        int[][] k2 = new int[k.length][k[0].length];
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                k2[i][j] = k[i][j];
            }
        }
        return k2;
    }

    public static int max(int[] ns) {
        int max = 0;
        for (int n : ns) {
            max = Math.max(max, n);
        }
        return max;
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

    static String toDireciton(float deg) {
        String[] lib = "N,NNE,NE,ENE,E,ESE,SE,SSE,S,SSW,SW,WSW,W,WNW,NW,NNW".split(",");
        float t = 22.5f; // (360 / 16);
        return lib[(int) ((deg + 11.25f) / t) % 16];
    }

    static int toWind(float p) {
        float[] lib = {0.2f, 1.5f, 3.3f, 5.4f, 7.9f, 10.7f, 13.8f, 17.1f, 20.7f, 24.4f, 28.4f, 32.6f};
        for (int i = 0, l = lib.length; i < l; i++) {
            if (p <= lib[i]) {
                return i;
            }
        }
        return 12;
    }

    // 最大公約数
    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // 最小公倍数
    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static double[] simultaneousEquation(double a, double b, double c, double d, double e, double f) {
        double t = a * d - c * b;
        double x = (d * e - b * f) / t;
        double y = (a * f - c * e) / t;
        return new double[]{ x, y };
    }

    public static int[] spiralPos(int t) {
        int x = (int) Math.floor((-1 + Math.sqrt(1 + 4 * t)) / 2) + 1;
        int m = ((x % 2 * -2) + 1);
        int k = (x / 2) * m;
        // 残りの部分 = t - 総和
        int s = t - (x - 1) * ((x - 1) + 1);
        m *= -1;
        int mx = k;
        int my = k + s * m;
        if (x < s) {
            mx = k + (s - x) * m;
            my = k + x * m;
        }
        return new int[] {my, mx};
    }
}

class UnionFind {
    int[] par;
    int n;

    UnionFind(int n) {
        this.n = n;
        par = new int[n];
        for (int i = 0; i < n; i++) par[i] = i;
    }

    public int find(int x) {
        if (par[x] == x) return x;
        return par[x] = find(par[x]);
    }

    public boolean same(int x, int y) {
        return find(x) == find(y);
    }

    public void unite(int x, int y) {
        if (find(x) == find(y)) return;
        par[find(x)] = find(y);
    }
}

class DijkstraMatrix {
    int[][] a;
    boolean[] b;
    PriorityQueue<int[]> q;

    public DijkstraMatrix(int n) {
        a = new int[n + 1][n + 1];
        b = new boolean[n + 1];
        q = new PriorityQueue<int[]>(n + 1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
    }

    public void set(int i, int j, int cost) {
        a[i][j] = cost;
    }

    public int getCost(int s, int e) {
        Arrays.fill(b, false);
        q.clear();
        b[s] = true;
        int c = 0;
        for (int i = 0; i < a.length; ++i) {
            int[] t = q.poll();
            if (t[0] == e) {
                c = t[1];
                break;
            }
            b[t[0]] = true;
            for (int k = 0; k < a.length; k++) {

                if (!b[k] && a[t[0]][k] > 0) {
                    q.add(new int[]{k, t[1] + a[t[0]][k]});
                }
            }
        }
        return c;
    }
}


class Dice {
    static int[] dice;
    static int[][] dice_table =
            {{0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 3, 5, 2, 4, 0},
                    {0, 4, 0, 1, 6, 0, 3},
                    {0, 2, 6, 0, 0, 1, 5},
                    {0, 5, 1, 0, 0, 6, 2},
                    {0, 3, 0, 6, 1, 0, 4},
                    {0, 0, 4, 2, 5, 3, 0}

            };

    Dice(int x, int y) {
        dice = new int[6];
        dice[0] = x;
        dice[1] = y;
        dice[2] = dice_table[x][y];
        dice[3] = 7 - y;
        dice[4] = dice_table[y][x];
        dice[5] = 7 - x;
    }

    // http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0502
    static int[] roll(int dir) {
        int[] b = new int[6];
        if (dir == 1) {// South
            b[0] = dice[3];
            b[1] = dice[0];
            b[2] = dice[2];
            b[3] = dice[5];
            b[4] = dice[4];
            b[5] = dice[1];
        } else if (dir == 2) {// East
            b[0] = dice[4];
            b[1] = dice[1];
            b[2] = dice[0];
            b[3] = dice[3];
            b[4] = dice[5];
            b[5] = dice[2];
        } else if (dir == 3) {// North
            b[0] = dice[1];
            b[1] = dice[5];
            b[2] = dice[2];
            b[3] = dice[0];
            b[4] = dice[4];
            b[5] = dice[3];
        } else if (dir == 4) {// West
            b[0] = dice[2];
            b[1] = dice[1];
            b[2] = dice[5];
            b[3] = dice[3];
            b[4] = dice[0];
            b[5] = dice[4];
        } else if (dir == 5) {// Left
            b[0] = dice[0];
            b[1] = dice[4];
            b[2] = dice[1];
            b[3] = dice[2];
            b[4] = dice[3];
            b[5] = dice[5];
        } else {// Right
            b[0] = dice[0];
            b[1] = dice[2];
            b[2] = dice[3];
            b[3] = dice[4];
            b[4] = dice[1];
            b[5] = dice[5];
        }
        return b;
    }

    // TODO:
    static void print_perm(int[] perm){
        for(int x: perm){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static void make_perm(int n, int[] perm, boolean[] flag){
        if(n == perm.length){
            print_perm(perm);
        } else {
            for(int i = 1; i <= perm.length; i++){
                if(flag[i]) continue;
                perm[n] = i;
                flag[i] = true;
                make_perm(n + 1, perm, flag);
                flag[i] = false;
            }
        }
    }

    // TODO:
    static int limit(int n, int up, int down) {
        return Math.max(down, Math.min(n, up));
    }

}
