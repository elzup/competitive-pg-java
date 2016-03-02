package atcoder.arc010;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class QbChainHoriday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> horidays = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            horidays.add(sc.next());
        }
        Calendar c = Calendar.getInstance();
        c.set(2012, 0, 1);
        int chainMax = 0;
        int chain = 0;
        int stack = 0;
        for (int i = 0; i < 366; i++) {
            int m = c.get(Calendar.MONTH) + 1;
            int d = c.get(Calendar.DAY_OF_MONTH);
            String key = m + "/" + d;
            boolean isHoriday = horidays.contains(key);
            int day = c.get(Calendar.DAY_OF_WEEK);
            boolean isWeekend = day == Calendar.SUNDAY || day == Calendar.SATURDAY;
            if (isHoriday) {
                stack ++;
            }

            if (isWeekend) {
                chain ++;
            } else if (stack > 0) {
                chain ++;
                stack --;
            } else if (chain > 0) {
                chainMax = Math.max(chain, chainMax);
                chain = 0;
            }

            c.add(Calendar.DATE, 1);
        }
        chainMax = Math.max(chain, chainMax);
        System.out.println(chainMax);
    }
}