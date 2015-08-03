package paiza;

import java.util.ArrayList;
import java.util.Scanner;

public class A005Boul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        ArrayList<Integer> plus = new ArrayList<>();
        sc.nextLine();
        String[] line = sc.nextLine().split(" ");

        int i = 0;
        int sum = 0;
        for (int fi = 0; fi < a; fi++) {
            if (fi == a - 1) {
                int p = 0;
                boolean chain = false;
                if (! line[i].equals("G")) {
                    p = Integer.parseInt(line[i]);
                }
                i++;
                sum += (plus.size() + 1) * p;
                for (int j = 0; j < plus.size();) {
                    if (plus.get(j) == 1) {
                        plus.remove(j);
                        continue;
                    }
                    plus.set(j, plus.get(j) - 1);
                    j++;
                }
                if (p == b) {
                    plus.add(2);
                    chain = true;
                }

                // second
                int p2 = 0;
                if (! line[i].equals("G")) {
                    p2 = Integer.parseInt(line[i]);
                }
                i++;
                sum += (plus.size() + 1) * p2;
                for (int j = 0; j < plus.size();) {
                    if (plus.get(j) == 1) {
                        plus.remove(j);
                        continue;
                    }
                    plus.set(j, plus.get(j) - 1);
                    j++;
                }
                if (p + p2 == b) {
                    plus.add(1);
                    chain = true;
                }
                if (!chain) {
                    break;
                }

                // second
                int p3 = 0;
                if (! line[i].equals("G")) {
                    p3 = Integer.parseInt(line[i]);
                }
                sum += (plus.size() + 1) * p3;
                break;
            }
            // first
            int p = 0;
            if (! line[i].equals("G")) {
                p = Integer.parseInt(line[i]);
            }
            i++;
            sum += (plus.size() + 1) * p;
            for (int j = 0; j < plus.size();) {
                if (plus.get(j) == 1) {
                    plus.remove(j);
                    continue;
                }
                plus.set(j, plus.get(j) - 1);
                j++;
            }
            if (p == b) {
                plus.add(2);
                continue;
            }

            // second
            int p2 = 0;
            if (! line[i].equals("G")) {
                p2 = Integer.parseInt(line[i]);
            }
            i++;
            sum += (plus.size() + 1) * p2;
            for (int j = 0; j < plus.size();) {
                if (plus.get(j) == 1) {
                    plus.remove(j);
                    continue;
                }
                plus.set(j, plus.get(j) - 1);
                j++;
            }
            if (p + p2 == b) {
                plus.add(1);
            }
        }
        System.out.println(sum);
    }
}


