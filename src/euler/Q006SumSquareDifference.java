package euler;

public class Q006SumSquareDifference {
    public static void main(String[] args) {
        int n = 100;
        int res1 = 0;
        for (int i = 1; i <= n; i++) {
            res1 += i * i;
        }
        int t = n * (n + 1) / 2;
        int res2 = t * t;
        System.out.println(res2 - res1);
    }
}
