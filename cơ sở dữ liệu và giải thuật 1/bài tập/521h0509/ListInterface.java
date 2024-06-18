import java.util.NoSuchElementException;

public interface ListInterface<E> {

    public int size();

    public boolean isEmpty();

    public void addFirst(E item);

    public void addLast(E item);

    public E removeFirst() throws NoSuchElementException;

    public E removeLast() throws NoSuchElementException;

    public boolean contains(E item);

    public E getFirst();

    public E getLast();

    public void print();

    public void addAfter(Node<E> curr, E item);

    public E removeAfter(Node<E> curr) throws NoSuchElementException;

    public E removeAt(int i) throws NoSuchElementException;

    public E getAt(int i);

}
