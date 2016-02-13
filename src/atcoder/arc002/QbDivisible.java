package atcoder.arc002;

import java.util.Calendar;
import java.util.Scanner;

public class QbDivisible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.next().split("/");
        int y = Integer.valueOf(nums[0]);
        int m = Integer.valueOf(nums[1]) - 1;
        int d = Integer.valueOf(nums[2]);
        Calendar cal = Calendar.getInstance();
        cal.set(y, m, d);
        while(true) {
            y = cal.get(Calendar.YEAR);
            m = cal.get(Calendar.MONTH) + 1;
            d = cal.get(Calendar.DAY_OF_MONTH);
            // System.out.println("*" + y + "/" + m + "/" + d);
            if (y % (m * d) == 0) {
                System.out.printf("%04d/%02d/%02d\n", y, m, d);
                return;
            }
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
}
