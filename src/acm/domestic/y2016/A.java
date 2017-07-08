package acm.domestic.y2016;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {

            int n = sc.nextInt();

            if (n == 0)
                break;

            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j < n; j++) {
                    if (Math.abs(nums[i] - nums[j]) < min){
                        min = Math.abs(nums[i] - nums[j]);
                    }
                }
            }
            System.out.println(min);
        }
    }
}
