package template;

public class Utils {

    final static int AN = (int) 'a';
    final static int ZN = (int) 'z';
    final static int LBN = (int) '(';
    final static int RBN = (int) ')';
    final static int _0N = (int) '0';
    final static int _9N = (int) '9';

    final static int INF = Integer.MAX_VALUE;
    final static int MIN = Integer.MIN_VALUE;
    final static int LIM = 1000000007;

    final static int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

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

    public static int[][] arrayCopy(int[][] k) {
        int[][] k2 = new int[k.length][k[0].length];
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                k2[i][j] = k[i][j];
            }
        }
        return k2;
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
        return new double[]{x, y};
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
        return new int[]{my, mx};
    }
}

