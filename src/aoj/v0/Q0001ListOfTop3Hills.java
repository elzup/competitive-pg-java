package aoj.v0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q0001ListOfTop3Hills {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            a.add(sn.nextInt());
        }
        Collections.sort(a);
        for (int i = 0; i < 3; i++) {
            System.out.println(a.get(a.size() - i - 1));
        }
    }
}
