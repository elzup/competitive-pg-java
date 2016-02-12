package atcoder.arc001;

import java.util.Scanner;

public class QaScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = new Integer(sc.nextLine());
        String cs = sc.nextLine();
        int[] res = new int[]{0, 0, 0, 0};
        for (int i = 0; i < cs.length();i ++) {
            System.out.println(Integer.valueOf(cs.charAt(i)) - 1);
            res[Integer.valueOf(cs.charAt(i)) - 1]++;
        }
    }
}
