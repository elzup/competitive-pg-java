package atcoder.arc.arc052;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QaNumFind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String regex = "[0-9]+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        if (m.find()) {
            m.group();
            System.out.println(m.group());
        }

    }
}
