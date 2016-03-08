package euler;

public class Q003LargestPrimeFactor {
    public static void main(String[] args) {
        long n = 600851475143L;

        for (int i = 2; i < n; i++) {
            while (n % i == 0) {
                n /= i;
            }
        }
        System.out.println(n);
    }
}
