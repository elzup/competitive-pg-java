package acm.kyusyu2011;

import java.util.ArrayList;
import java.util.Scanner;

public class QdCircleDips {
    static int n;
    static ArrayList<Circle> circles;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }
            circles = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int r = sc.nextInt();
                int c = sc.nextInt();
                circles.add(new Circle(x, y, r, c, i));
            }
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    Circle c1 = circles.get(i);
                    Circle c2 = circles.get(j);
                    if (c1.dip(c2)) {
                        c1.children.add(c2);
                        c2.parents.add(c1);
                    }
                }
            }
            max = Integer.MIN_VALUE;
            dp(0);
            System.out.println(max * 2);
        }
    }

    static void dp(int k) {
        max = Math.max(max, k);

        ArrayList<Circle> tops = new ArrayList<>();
        for (Circle c: circles) {
            if (c.parents.isEmpty()) {
                tops.add(c);
            }
        }

        for (int i = 1; i <= 4; i++) {
            ArrayList<Circle> items = new ArrayList<>();
            for (Circle c: tops) {
                if (c.c == i) {
                    items.add(c);
                }
            }

            if (items.size() < 2) {
                continue;
            }
            // TODO: sum6 枝刈り
            if (items.size() == 6) {
                circles.removeAll(items);
                for (Circle c: items) {
                    for (Circle t : c.children) {
                        t.parents.remove(c);
                    }
                }
                dp(k + 3);
                for (Circle c: items) {
                    for (Circle t : c.children) {
                        t.parents.add(c);
                    }
                }
                circles.addAll(items);
            } else {
                for (int j = 0; j < items.size() - 1; j++) {
                    for (int l = j + 1; l < items.size(); l++) {
                        Circle c1 = items.get(j);
                        Circle c2 = items.get(l);
                        circles.remove(c1);
                        circles.remove(c2);
                        for (Circle c : c1.children) {
                            c.parents.remove(c1);
                        }
                        for (Circle c : c2.children) {
                            c.parents.remove(c2);
                        }
                        dp(k + 1);
                        circles.add(c1);
                        circles.add(c2);
                        for (Circle c : c1.children) {
                            c.parents.add(c1);
                        }
                        for (Circle c : c2.children) {
                            c.parents.add(c2);
                        }
                    }
                }
            }
        }
    }

    static class Circle {
        int x, y, r, c, id;
        ArrayList<Circle> parents;
        ArrayList<Circle> children;
        Circle (int x, int y, int r, int c, int id) {
            this.x = x;
            this.y = y;
            this.r = r;
            this.c = c;
            this.id = id;
            parents = new ArrayList<>();
            children = new ArrayList<>();
        }

        public boolean dip(Circle c) {
            return Math.pow(this.r + c.r, 2) > Math.pow(this.x - c.x, 2) + Math.pow(this.y - c.y, 2);
        }

    }
}

