package euler;

public class Q002EvenFibonacci {
    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        int k = i + j;
        int sum = 2;
        while (k < 4000000) {
            if (k % 2 == 0) {
                sum += k;
            }
            k = i + j;
            i = j;
            j = k;
        }
        System.out.println(sum);
    }
}

