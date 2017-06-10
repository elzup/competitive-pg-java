import java.util.ArrayList;

public class PrimeFirstDigitChain {
    static ArrayList<Integer> primes;
    static int n;
    static int[][] map;
    static int[][][] chainMap;
    static int[] sums;
    static int max, start, skip;

    public static void main(String[] args) {
        max = 10000000;
        // max = 10000;
        // max = 100;
        start = 0;
        // 半分から先のみ統計
        // start = max / 2;
        skip = 1;
        primes = new ArrayList<>();
        primes.add(2);
        n = 2;

        map = new int[10][10];
        chainMap = new int[10][10][10];
        sums = new int[10];

        for (int i = 0; i < max; i++) {
            int next = nextPrime();
            if (i < start) {
                continue;
            }
            if (i < skip) {
                continue;
            }
            int pre = primes.get(i - (skip - 1));
            if (i < skip + 3) {
                System.out.println(pre + ":" + next);
            } else if (i == skip + 3) {
                System.out.println(".....\n");
            }
            map[pre % 10][next % 10]++;
            sums[pre % 10]++;
            if (i > skip) {
                int pre2 = primes.get(i - (skip));
                chainMap[pre2 % 10][pre % 10][next % 10]++;
            }
        }

        System.out.println("Start: " + start);
        System.out.println("SampleNum: " + max);
        System.out.println("Skip: " + skip);
        for (int i = 0; i < 10; i++) {
            if (!isTarget(i)) { continue; }
            System.out.println("from " + i + " <" + sums[i] + ">");
            for (int j = 0; j < 10; j++) {
                if (!isTarget(j)) { continue; }
                System.out.printf("%d: %d (%.2f %%)\n", j, map[i][j], map[i][j] * 100.0f / sums[i]);
                for (int k = 0; k < 10; k++) {
                    if (!isTarget(k)) { continue; }
                    System.out.printf("\t\t%d: %d (%.2f %%)\n", k, chainMap[i][j][k], chainMap[i][j][k] * 100.0f / sums[i]);
                }
            }
            System.out.println();
        }
    }

    static boolean isTarget(int n) {
        return (n == 1 || n == 3 || n == 7 || n == 9);
    }

    static int nextPrime() {
        while (true) {
            n ++;
            if (isPrime(n)) {
                primes.add(n);
                return n;
            }
        }
    }
    static boolean isPrime(int n) {
        for (int p : primes) {
            if (n % p == 0) {
                return false;
            }
        }
        return true;
    }

}
