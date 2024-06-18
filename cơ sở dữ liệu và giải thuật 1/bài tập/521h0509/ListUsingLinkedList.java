import java.util.NoSuchElementException;

public class ListUsingLinkedList<E> implements ListInterface<E> {
    Node<E> head;
    private int numNode;

    public ListUsingLinkedList() {
        head = null;
        numNode = 0;
    }

    @Override
    public int size() {
        return numNode;
    }

    @Override
    public boolean isEmpty() {
        // return numNode == 0;
        return head == null;
    }

    @Override
    public void addFirst(E item) {
        // if (isEmpty()) {
        // head = new Node<>(item, null);
        // } else {
        // Node<E> n = new Node<>(item, head);
        // head = n;
        // }
        head = new Node<>(item, head);
        numNode++;
    }

    @Override
    public void addLast(E item) {

    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty list");
        }

        E item = head.getData();
        head = head.getNext();
        numNode--;
        return item;
    }

    @Override
    public E removeLast() throws NoSuchElementException {
        if (!isEmpty()) {
            return null;
        }
        Node<E> p = null, n = head;
        while (n.getNext() != null) {
            p = n;
            n = n.getNext();
        }

        E tmp = n.getData();
        if (p != null) {
            p.setNext(null);
        } else {
            head = null;
        }
        numNode--;

        return tmp;
    }

    @Override
    public boolean contains(E item) {
        Node<E> n = head;
        while (n != null) {
            if (n.getData().equals(item)) {
                return true;
            }
            n = n.getNext();
        }
        return false;
    }

    @Override
    public E getFirst() {
        // if (! isEmpty()) {
        // return head.getData();
        // }
        // return null;

        return isEmpty() ? null : head.getData();
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> cur = head;
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }
        E found = cur.getData();
        return found;
    }

    @Override
    public void print() {
        System.out.print("[");
        // for(Node<E> n = head;
        // n != null;
        // n = n.getNext()) {

        // System.out.print(n.getData() + ", ");
        // }
        Node<E> n = head;
        while (n != null) {
            System.out.print(n.getData() + ", ");
            n = n.getNext();
        }

        System.out.println("]");

    }

    @Override
    public void addAfter(Node<E> curr, E item) {
        Node<E> fond, cur;
        for (fond = null, cur = head; cur != null; cur = cur.getNext()) {
            if (cur.getData().equals(curr.getData())) {
                fond = new Node<>(item, cur.getNext());
                cur.setNext(fond);
                numNode++;
                break;
            }
        }

    }

    @Override
    public E removeAfter(Node<E> curr) throws NoSuchElementException {
        Node<E> cur;
        E find = null;
        for (find = null, cur = head; cur != null; cur = cur.getNext()) {
            if (cur.getData().equals(curr.getData()) && cur.getNext() != null) {
                find = cur.getNext().getData();
                cur.setNext(cur.getNext().getNext());
                numNode--;
                break;
            }
        }
        return find;
    }

    @Override
    public E removeAt(int i) throws NoSuchElementException {
        Node<E> then, now;
        int j;
        E found = null;
        for (j = 0, then = null, now = head; now != null; then = now, now = now.getNext(), j++) {
            if ((j == i) && then != null) {
                then = now.getNext();
                found = now.getData();
                numNode--;
            } else if (then == null) {
                head = head.getNext();
                found = now.getData();
                numNode--;
            }
        }
        return found;
    }

    @Override
    public E getAt(int i) {
        Node<E> now;
        int j;

        for (j = 0, now = head; now != null; now = now.getNext(), j++) {
            if ((j == i)) {
                return now.getData();
            }
        }
        return null;
    }
}
