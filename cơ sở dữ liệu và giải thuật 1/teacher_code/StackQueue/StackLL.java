import java.util.*;

public class StackLL<E> implements StackADT<E> {
	private BasicLinkedList<E> list; // Why private? 

	public StackLL() {
		list = new BasicLinkedList <E> ();
	}

	@Override
	public boolean empty() { 
        return list.isEmpty(); 
    }
	
	@Override
	public E peek() throws EmptyStackException {
		// try {
		// 	return list.getFirst();
		// } catch (NoSuchElementException e) {
		// 	throw new EmptyStackException();
		// }
        if (!empty()) {
            return list.getFirst();
        } else {
            throw new EmptyStackException();
        }
	}

	@Override
	public E pop() throws EmptyStackException {
		E obj = peek();
		list.removeFirst();
		return obj;
	}

	@Override
	public void push(E o) {
		list.addFirst(o);
	}
}
