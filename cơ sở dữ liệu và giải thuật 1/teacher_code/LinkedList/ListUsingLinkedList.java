import java.util.NoSuchElementException;

public class ListUsingLinkedList<E>
    implements ListInterface<E> {
    private Node<E> head, tail;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty list");
        }
        return head.getData();
    }

    @Override
    public boolean contains(E item) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void addFirst(E item) {
        // if (! isEmpty()) {
        //     Node<E> n = new Node<>(item, head);
        //     head = n;
        // } else {
        //     head = new Node<>(item, null);
        // }
        head = new Node<>(item, head);
    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty list");
        }
        E tmp = head.getData();
        head = head.getNext();
        return tmp;
    }

    @Override
    public void print() {
        Node<E> n = head;
        while (n != null) {
            System.out.print(n.getData() + ", ");
            n = n.getNext();
        }
        System.out.println();
    }
    
}
