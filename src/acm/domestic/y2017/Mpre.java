package acm.domestic.y2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Mpre {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int max = 1000000;
    ArrayList<Integer> list = new ArrayList<>();
    while (true) {
      int n2 = sc.nextInt();
      if (n2 == 0) {
        break;
      }
      list.add(n2);
    }
    Collections.sort(list);

    ArrayList<Bob> bobs = new ArrayList<>();
    for (int i = 0; i < list.size() - 1; i++) {
      int a = list.get(i);
      int b = list.get(i + 1);
      bobs.add(new Bob(a, b));
      System.out.println(a + "::" + b + " > " + (b - a));
    }

    bobs.add(new Bob(0, list.get(0)));
    bobs.add(new Bob(list.get(list.size() - 1), 1000000));

    Collections.sort(bobs);
    for (Bob b: bobs) {
      System.out.println(b.low + ":" + b.high + " > " + b.diff);
    }
  }

  static class Bob implements Comparable<Bob> {

    int low;
    int high;
    int diff;

    Bob(int low, int high) {
      this.low = low;
      this.high = high;
      this.diff = this.high - this.low;
    }


    @Override
    public int compareTo(Bob o) {
      return this.diff - o.diff;
    }
  }
}
