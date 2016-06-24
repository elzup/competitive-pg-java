package acm.domestic.y2016.rehearsal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class M {
    public static void main(String[] args) {
        int secret = 825352;
        Scanner sc = new Scanner(System.in);
        while (true) {
            int tmp = sc.nextInt();
            if (tmp == 0)
                break;

            if (tmp < secret) {
                System.out.println("smaller");
            } else {
                System.out.println("larger");
            }
        }
    }

    static void memo() {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<SortNum> sort_nums = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        while (true) {
            int tmp = sc.nextInt();
            if (tmp == 0)
                break;

            nums.add(tmp);
        }
        Collections.sort(nums);

        for (int i = 1; i < nums.size(); i++) {
            sort_nums.add(new SortNum(nums.get(i) - nums.get(i - 1), nums.get(i - 1) + 1));
        }

        Collections.sort(sort_nums);
        sort_nums.forEach(System.out::println);
//        nums.forEach(System.out::println);
    }

    static class SortNum implements Comparable<SortNum> {
        int range;
        int num;

        public SortNum(int range, int num) {
            this.range = range;
            this.num = num;
        }

        @Override
        public int compareTo(SortNum o) {
            return this.range - o.range;
        }

        @Override
        public String toString() {
            return "SortNum{" +
                    "range=" + range +
                    ", num=" + num +
                    '}';
        }
    }
}
