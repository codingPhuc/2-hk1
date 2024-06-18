import java.security.Principal;

public class ex8 {
    static MyLinkedList<Integer> list = new MyLinkedList<>();

    public ex8(MyLinkedList<Integer> list) {
         this.list = list;

    }

    public static Node addSortedList(Node item) {

        if (( (Integer) list.getHead().getData() < (Integer) list.getHead().getData()) {
            item.setNext(list.getHead());
            return item;
        } else {
            list.getHead().setNext(addSortedList(item));
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
        addSortedList(node);
        list.print();
        System.out.println(countEven(list.getHead()));
    }
}
