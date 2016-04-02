package atcoder.arc.arc050;

public class Main {
    public static void main(String[] args) {
        int[] list = new int[]{ 1, 11, 111, 1111, 11111, 111111};
        for (int a: list) {
            for (int b: list) {
                System.out.printf("lcm(%d, %d) = %d\n", a, b, lcm(a, b));
            }
        }
    }

    // 最大公約数
    static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }

    // 最小公倍数
    static int lcm(int a, int b){
        return a * b / gcd(a, b);
    }

}
