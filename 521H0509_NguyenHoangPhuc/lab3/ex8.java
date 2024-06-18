import java.security.Principal;

public class ex8 {
    public static Node addSortedList(Node head, Node item) {

        if ((Integer) item.getData() < (Integer) head.getData()) {
            item.setNext(head);
            return item;
        } else {
            head.setNext(addSortedList(head.getNext(), item));
        }
        return item;
    }

    public static int sumLinkList(Node head) {
        if (head == null) {
            return 0;
        }
        return (Integer) head.getData() + sumLinkList(head.getNext());
    }

    public static int countEven(Node head) {
        if (head == null) {
            return 0;
        }
        return ((Integer) head.getData() + 1) % 2 + countEven(head.getNext());

    }

    public static void main(String arg[]) {

        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i = i + 2)
            list.addFirst(i + 2);
        list.sortList();
        list.print();
        Node<Integer> node = new Node<>(3);
        addSortedList(list.getHead(), node);
        list.print();
        System.out.println(countEven(list.getHead()));
    }
}
