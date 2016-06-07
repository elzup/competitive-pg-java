package acm.domestic.y2015;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class E {
    public static int INF = Integer.MAX_VALUE;
    static Scanner sc;
    static PrintWriter pw;
    static String id = "E2";
    static String input = "/Users/hiro/Downloads/" + id;
    static String output = "src/acm/tsukuba2015/out_" + id + ".txt";

    public static void main(String[] args) {
        init();

        while (true) {
            int n = ni();
            if (n == 0) {
                break;
            }
            nl();
            String s = nl();
            System.out.println(s);

            ArrayList<Thread> threads = new ArrayList<>();
            Thread.operator = s;

            while (true) {
                System.out.println(threads.size());
                if (threads.size() == 0 || threads.stream().allMatch(t -> t.isLocked)) {
                    threads.add(new Thread());
                  }
                else if(threads.size() >=10){
                    continue;
                }
                for (int i = 0; i< threads.size(); i++) {
                    Thread t = threads.get(i);
                    if (t.isCompleted()) {
                        t.unlock();
                        continue;
                    }
                    if (t.next() == 'u') {
                        t.unlock();
                        threads.stream().forEach(t2 -> t2.isLocked = false);
                    } else {
                        char c = t.next();
                        if (threads.stream().anyMatch(t2 -> t2.lock.contains(c + ""))) {
                            t.isLocked = true;
                        } else {
                            t.lock += c;
                            t.pointer++;
                            threads.stream().forEach(t2 -> t2.isLocked = false);
                            threads.add(new Thread());
                        }
                    }
                }
                if (threads.stream().allMatch(t -> t.isLocked)) {
                    pw.println("UNSAFE");
                    break;
                }
            }
            if (threads.size() >= 10) {
                pw.println("SAFE");
            }
        }
        end();
    }

    public static void init() {
        try {
            System.setProperty("line.separator", "\r\n");
            sc = new Scanner(new File(input));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(output)));
            pw = new PrintWriter(bw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void end() {
        sc.close();
        pw.close();
    }

    public static int ni() {
        return sc.nextInt();
    }

    public static String nl() {
        return sc.nextLine();
    }
}

class Thread {
    public String lock = "";
    public int pointer;
    public static String operator;

    public boolean isLocked = false;

    public boolean isCompleted() {
        return this.pointer >= operator.length();
    }

    public void unlock() {
        this.lock = "";
    }

    public char next() {
        return operator.charAt(this.pointer);
    }
}
