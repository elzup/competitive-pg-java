package acm.domestic.y2011;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class QbBrancket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Deque<String> stack = new ArrayDeque<>();
            String line = sc.nextLine();
            if (line.equals(".")) {
                break;
            }
            boolean t = true;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '(' || c == '[') {
                    stack.push(c + "");
                } else if (c == ')') {
                    if (stack.size() == 0 || !stack.poll().equals("(")) {
                        t = false;
                        break;
                    }
                } else if (c == ']') {
                    if (stack.size() == 0 || !stack.poll().equals("[")) {
                        t = false;
                        break;
                    }
                }
            }
            if (t && stack.size() == 0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
