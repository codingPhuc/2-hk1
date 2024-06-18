import java.util.*;

public class QueueLL <E> implements QueueADT <E> {
	private BasicLinkedList <E> list;

	public QueueLL() { 
        list = new BasicLinkedList <E> (); 
    }

	public boolean isEmpty() { 
        return list.isEmpty(); 
    }

	public boolean offer(E o) { 
		list.addLast(o);   // isEmpty(), addLast(), getFirst(), removeFirst() 
						 // are public methods of TailedLinkedList
		return true;
	}

	public E peek() {
		// if (isEmpty()) 
        //     return null;
		// return list.getFirst();
		return isEmpty()? null: list.getFirst();
	}

	public E poll() {
		// E obj = peek();
		// if (!isEmpty()) 
        //     list.removeFirst();
		// return obj;
		return isEmpty()? null: list.removeFirst();
	}
}
