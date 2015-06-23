package algo;

import com.sun.xml.internal.ws.api.message.Packet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by hiro on 5/16/15.
 */
public class NapSac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<NapSac.Item> items = new ArrayList<Item>();
        HashMap<Integer, Integer> status = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int cost = sc.nextInt();
            int value = sc.nextInt();
            items.add(new NapSac.Item(cost, value));
        }
        status.put(0, 0);
        for (Item item : items) {
            HashMap<Integer, Integer> newStatus = new HashMap<Integer, Integer>();
            for (Integer index: status.keySet()){
                Integer value = status.get(index);
                if (!newStatus.containsKey(index) || newStatus.get(index) < value) {
                        newStatus.put(index, value);
                }
                int newIndex = index + item.cost;
                int newValue = value + item.value;
                if (newIndex > m) {
                    continue;
                }
                if (!newStatus.containsKey(newIndex) || newStatus.get(newIndex) < newValue) {
                    newStatus.put(newIndex, newValue);
                }
            }
            status = newStatus;
        }
        int max = 0;
        for (Integer key : status.keySet()) {
            max = Math.max(max, status.get(key));
//            System.out.println(key + ": " + status.get(key));
        }
        System.out.println(max);
    }

    public static class Item {
        public int cost;
        public int value;
        public Item (int cost, int value) {
            this.cost = cost;
            this.value = value;
        }
    }

}

/*

input
10
300
168 496
10  45
145 325
60  347
10  61
124 486
124 446
105 22
126 110
184 475


a.
1, 4, 5, 6
1038
 */
