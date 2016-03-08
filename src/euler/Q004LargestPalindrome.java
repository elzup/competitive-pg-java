package euler;

public class Q004LargestPalindrome {
    public static void main(String[] args) {
        long max = 0;
        for (int i = 100; i < 999; i++) {
            for (int j = 100; j < 999; j++) {
                int t = i * j;
                StringBuilder ts = new StringBuilder(String.valueOf(t));

                if (ts.toString().equals(ts.reverse().toString())) {
                    max = Math.max(max, t);
                }
            }
        }
        System.out.println(max);
    }
}
