import java.util.Random;
import java.util.NoSuchElementException;

public class TestListUsingLinkedList {
    public static void main(String[] args) {
        ListUsingLinkedList<Integer> list = new ListUsingLinkedList<>();
        Node<Integer> fond, cur;
        fond = new Node<>(1, null);
        Random rand = new Random();

        System.out.println("# Add");
        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
        }
        list.addAfter(fond, 5);
        list.print();

        System.out.println(list.removeAfter(fond));
        list.print();
        System.out.println("# Remove");
        for (int i = 0; i < 5; i += 2) {
            System.out.print("Remove at " + i + ": ");
            System.out.println(list.removeAt(i));
        }
        list.print();
        System.out.println("# Search");
        System.out.println("Last: " + list.getLast());
        System.out.println("First:" + list.getFirst());
        System.out.println("At 3: " + list.getAt(3));
    }
}