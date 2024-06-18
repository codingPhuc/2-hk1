import java.util.NoSuchElementException;

public interface ListInterface<E> {
    public boolean isEmpty();
	public int size();
	public E getFirst() throws NoSuchElementException;
	public boolean contains(E item);
	public void addFirst(E item);
	public void addLast(E item);
	public E removeFirst() throws NoSuchElementException;
	public void print() throws NoSuchElementException;
}
