package atcoder.rhd_test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();

        PointQueue fq = new PointQueue();
        PointQueue bq = new PointQueue();

        Point base_p = new Point(sc.nextInt(), sc.nextInt());
        for (int i = 1; i < N; i++) {
            Point p = new Point(sc.nextInt(), sc.nextInt());
            if (p.x <= L / 2) {
                fq.add(p, base_p);
            } else {
                bq.add(p, base_p);
            }
        }
        System.out.println(fq.sum_len + bq.sum_len);

        for (int i = 1; i < N; i++) {
            System.out.println(bq.sum_n + ":" + fq.sum_n);

            Point pre_p = base_p.clone();
            base_p = fq.peek();
            int ml = Math.abs(base_p.x - pre_p.x);
            fq.subLen(ml);
            bq.addLen(ml);

            bq.add(pre_p, base_p);

            // TODO null fq
            fq.poll(base_p);

            while (true) {
                // HACK:
                if (bq.isEmpty() || Math.abs(bq.peek().x - base_p.x) > L / 2) {
                    break;
                }
                Point sp = bq.poll(base_p);
                fq.add(sp, base_p);
            }
            System.out.println(fq.sum_len + bq.sum_len);
        }
    }

    static class PointQueue {
        private Queue<Point> queue = new ArrayDeque<>();
        public int sum_len;
        public int sum_n;

        public void add(Point p, Point base_p) {
            queue.add(p);
            int d = Math.abs(base_p.x - p.x);
            sum_len += d * p.n;
            sum_n += p.n;
        }

        public Point peek() {
            return this.queue.peek();
        }

        public Point poll(Point base_p) {
            Point p = this.queue.poll();
            int d = Math.abs(base_p.x - p.x);
            sum_len -= d * p.n;
            sum_n -= p.n;
            return p;
        }

        public void addLen(int ml) {
            this.sum_len += this.sum_n * ml;
        }

        public void subLen(int ml) {
            this.addLen(-ml);
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    static class Point implements Cloneable {
        public int x;
        public int n;

        Point(int x, int n) {
            this.x = x;
            this.n = n;
        }

        public Point clone() {
            return new Point(x, n);
        }
    }
}
