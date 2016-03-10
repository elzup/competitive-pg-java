package atcoder.abc.abc032;

import java.util.Scanner;

public class Main {
    // napsac ナップサック
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int capacity = sc.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            items[i] = new Item(w, v);
        }

        int[] way = new int[capacity + 1];
        way[0] = 1;
        int max = 0;
        for (Item item : items) {
            int[] new_way = new int[capacity + 1];
            for (int i = 0; i < capacity; i++) {
                if (way[i] != 0) {
                    new_way[i] = Math.max(new_way[i], way[i]);
                    max = Math.max(max, new_way[i]);
                    if (i + item.weight <= capacity) {
                        new_way[i + item.weight] = way[i] + item.point;
                        max = Math.max(max, new_way[i + item.weight]);
                    }
                }
            }
            way = new_way;
            // arrayDump(way);
        }
        System.out.println(max - 1);
    }

    public static void arrayDump(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%3d", a[i]);
        }
        System.out.println();
    }

    public static class Item {
        public int weight;
        public int point;

        public Item(int weight, int point) {
            this.weight = weight;
            this.point = point;
        }
    }
}
