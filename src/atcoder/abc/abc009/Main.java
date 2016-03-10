package atcoder.abc.abc009;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        if (k <= 1) {
            System.out.println(s);
            return;
        }

        List<String> sa = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sa.add(String.valueOf(s.charAt(i)));
        }
        Collections.sort(sa);
        String t = "";
        for (int i = 0; i < n; i++) {
            t += sa.get(i);
        }
        ArrayList<Integer> swapped = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String c1 = String.valueOf(s.charAt(i));
            String c2 = String.valueOf(t.charAt(i));
            if (c1.equals(c2)) {
                continue;
            }
            int pi = s.substring(i).indexOf(c2) + i;
            // System.out.println(pi);
            if (k - swapped.size() >= 2) {
                // System.out.println("--");
                // System.out.println(i);
                // System.out.println(c2);
                // System.out.println(c1);
                // System.out.println("--");
                s = s.substring(0, i) + c2 + s.substring(i + 1, pi) + c1 + s.substring(pi + 1);
                if (!swapped.contains(i)) {
                    swapped.add(i);
                }
                if (!swapped.contains(pi)) {
                    swapped.add(pi);
                }
            } else if (k - swapped.size() == 1) {
                if (swapped.contains(pi) || swapped.contains(i)) {
                    s = s.substring(0, i) + c2 + s.substring(i + 1, pi) + c1 + s.substring(pi + 1);
                    if (!swapped.contains(i)) {
                        swapped.add(i);
                    }
                    if (!swapped.contains(pi)) {
                        swapped.add(pi);
                    }
                } else {
                    for (int j = i + 1; j < n; j++) {
                        String c3 = String.valueOf(t.charAt(i));
                        int pi2 = s.indexOf(c3);
                        if (swapped.contains(pi2)) {
                            s = s.substring(0, i) + c3 + s.substring(i + 1, pi2) + c1 + s.substring(pi2 + 1);
                            if (!swapped.contains(pi2)) {
                                swapped.add(pi2);
                            }
                            break;
                        }
                    }
                }
            } else if (k - swapped.size() == 0) {
                if (swapped.contains(i)) {
                    for (int j = i + 1; j < n; j++) {
                        String c3 = String.valueOf(t.charAt(i));
                        int pi2 = s.indexOf(c3);
                        if (swapped.contains(pi2)) {
                            s = s.substring(0, i) + c3 + s.substring(i + 1, pi2) + c1 + s.substring(pi2 + 1);
                            if (!swapped.contains(pi2)) {
                                swapped.add(pi2);
                            }
                            break;
                        }
                    }
                }
            }
            if (k - swapped.size() <= 0 && swapped.size() < 2) {
                break;
            }
        }
        System.out.println(s);
    }
}
