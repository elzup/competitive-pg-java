package codeiq.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StreamMedian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> sortedList = new ArrayList<>();
        while (sc.hasNext()) {
            int v = sc.nextInt();
            int pos = Collections.binarySearch(sortedList, v);
            sortedList.add(pos >= 0 ? pos : ~pos, v);

            int center = sortedList.get(sortedList.size() / 2);
            if (sortedList.size() % 2 == 0) {
                center = (center + sortedList.get(sortedList.size() / 2 - 1)) / 2;
            }
            System.out.println(center);
        }
    }
}
