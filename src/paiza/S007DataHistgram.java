package paiza;

import java.util.*;

public class S007DataHistgram {
    static int AN = (int) 'a';
    static int ZN = (int) 'z';
    static int LBN = (int) '(';
    static int RBN = (int) ')';
    static int _0N = (int) '0';
    static int _9N = (int) '9';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Long> counts = new HashMap<>();
        for (int i = AN; i <= ZN; i++) {
            counts.put((char) i, 0L);
        }
        String line = sc.nextLine();
        Deque<Long> stack = new ArrayDeque<>();

        String numCacheStr = "";
        for (int i = 0, l = line.length(); i < l; i++) {
            char c = line.charAt(i);
            int cn = (int) c;
            // System.out.println("-" + c + ": " + cn);
            if (_0N <= cn && cn <= _9N) { // 1-9
                numCacheStr += c;
                // System.out.println("> " + numCacheStr);
            } else if (AN <= cn && cn <= ZN) { // a-z
                if ("".equals(numCacheStr)) {
                    counts.put(c, counts.get(c) + infiniteProduct(toLongArray(stack.toArray())));
                } else {
                    stack.addFirst(Long.parseLong(numCacheStr));
                    numCacheStr = "";
                    counts.put(c, counts.get(c) + infiniteProduct(toLongArray(stack.toArray())));
                    stack.removeFirst();
                    // System.out.println("< " + numCacheStr);
                }
            } else if (cn == LBN) { // (
                stack.addFirst(Long.parseLong(numCacheStr));
                numCacheStr = "";
            } else if (cn == RBN) { // )
                stack.removeFirst();
                // System.out.println("< " + numCacheStr);
            }
        }
        for (Map.Entry<Character, Long> entry: counts.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static long[] toLongArray(Object[] objs) {
        int l = objs.length;
        long[] a = new long[l];
        for (int i = 0; i < l; i++) {
            a[i] = (long) objs[i];
        }
        return a;
    }

    public static long infiniteProduct(long[] list, int i) {
        if (i == list.length) {
            return 1L;
        }
        return infiniteProduct(list, i + 1) * list[i];
    }

    public static long infiniteProduct(long[] list) {
        return infiniteProduct(list, 0);
    }
}
