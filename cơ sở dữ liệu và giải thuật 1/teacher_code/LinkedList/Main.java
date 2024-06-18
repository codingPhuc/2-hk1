import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // String s1 = new String("An");
        // String s2 = new String("An");

        // System.out.println(s1 == s2);
        // System.out.println(s1.equals(s2));

        LinkedList<String> list = new LinkedList<>();
        list.add("Nguyen");
        list.add("Thanh");
        list.add("An");
        System.out.println(list.contains("@"));
        System.out.println(list);
    }
}
