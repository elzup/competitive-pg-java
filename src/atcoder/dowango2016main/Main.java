package atcoder.dowango2016main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> nums = under25num(n);
        Collections.reverse(nums);
        int c = 0;
        for (int i : nums) {
            // System.out.println(i);
            if (n % i == 0) {
                n /= i;
                c++;
                if (n == 1) {
                    break;
                }
            }
            if (n == 1) {
                break;
            }
        }
        System.out.println(c);
    }

    public static int dp(int[] nums, int n, int p) {
        if (n == 1) {
            return p;
        }
        return 0;
    }

    public static ArrayList<Integer> under25num(int n) {
        int i2 = 2;
        int i5 = 5;
        ArrayList<Integer> is = new ArrayList<>();
        int d = 0;
        while (true) {
            if (n < i2) {
                break;
            }
            is.add(i2);
            if (n < i5) {
                break;
            }
            is.add(i5);
            d++;
            i2 = i2 * 10 + (d % 2 == 0 ? 2 : 5);
            i5 = i5 * 10 + (d % 2 == 0 ? 5 : 2);
        }
        return is;
    }
}
