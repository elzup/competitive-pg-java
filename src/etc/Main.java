package etc;

public class Main {
    public static void main(String[] args) {
        String[] t = { "ほげ（あ）", "ふが（９〜８）" };
        String[] w = new String[20];
        for (int i = 0; i < t.length; i++) {
            t[i] = t[i].replaceAll("[（〜）]", "");
            System.out.println(t[i]);
        }
    }
}
