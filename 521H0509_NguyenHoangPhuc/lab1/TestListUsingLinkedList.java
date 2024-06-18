
import java.util.NoSuchElementException;
import java.util.Random;

public class TestListUsingLinkedList {
    public static <E> void main(String arg[]) {
        MyLinkedList<Fraction> list = new MyLinkedList<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            list.addFirst(new Fraction(i, i + 2));

        }
        list.print();
        // exercise 2
        MyLinkedList<Integer> list_2 = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list_2.addFirst(i + 2);
        }
        Node<Integer> n = new Node<>(5, null);
        list_2.print();
        int a = list_2.removeCurr(n);
        System.out.println(a);
        list_2.print();
        System.out.println("Count the number of even item in the list.");
        int count = list_2.countEven();
        System.out.println(count);
        System.out.println("Count the number of prime item in the list.");
        count = list_2.countPrime();
        System.out.println(count);
        System.out.println("Add item X before the first even element in the list.");
        Node<Integer> Item = new Node<>(0, null);
        int pokemon = list_2.addItem(Item);
        list_2.print();
        System.out.println("Find the maximum number in the list.");
        pokemon = list_2.maxNum();
        System.out.println(pokemon);
        System.out.println(" Sort the list in ascending order.");
        list_2.sortList();
        list_2.print();
        System.out.println("before revest list ");
        list.print();
        list.print();
        list.revestList();
        list.print();

    }

}