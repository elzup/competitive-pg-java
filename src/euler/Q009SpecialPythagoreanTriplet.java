package euler;

public class Q009SpecialPythagoreanTriplet {
    public static void main(String[] args) {
        int p = 0;
        for (int c = 333; c < 1000; c += 2) {
            int cl = 1000 - c;
            for (int b = (cl + 1) / 2; b < cl && b < c; b++) {
                int a = cl - b;
                if (a >= b || b >= c) {
                    System.out.println("無駄 --- " + a + ":" + b + ":" + c);
                    continue;
                }
                if (a * a + b * b == c * c) {
                    // System.out.println(a + ":" + b + ":" + c);
                    p = a * b * c;
                }
            }
        }
        System.out.println(p);
    }
}
