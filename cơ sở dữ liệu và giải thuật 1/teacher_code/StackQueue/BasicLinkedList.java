import java.util.*;

public class BasicLinkedList<E> 
			implements ListInterface <E> {
	private ListNode <E> head = null;
	private int num_nodes = 0;

	public boolean isEmpty() { return (num_nodes == 0); }

	public int size() { return num_nodes; }

	public E getFirst() throws NoSuchElementException {
		if (head == null) 
			throw new NoSuchElementException("can't get from an empty list");
		else return head.getElement();
	}

	public boolean contains(E item) {
		for (ListNode <E> n = head; n != null; n = n.getNext())
			if (n.getElement().equals(item)) return true;
		return false;
	}
	public void addFirst(E item) {
		head = new ListNode <E> (item, head); 
		num_nodes++;
	}

	public E removeFirst() throws NoSuchElementException {
		ListNode <E> ln;
		if (head == null) 
			throw new NoSuchElementException("can't remove from empty list");
		else { 
			ln = head;
			head = head.getNext();
			num_nodes--;
			return ln.getElement();
		}
	}

	public void print() throws NoSuchElementException {
		// ... Code omitted 
	}

	@Override
	public void addLast(E item) {
		if (isEmpty()) {
			addFirst(item);
		} else {
			ListNode<E> n = head;
			while (n.getNext() != null) {
				n = n.getNext();
			}
			n.setNext(new ListNode<E>(item, null));
			num_nodes++;
		}
	}
}
