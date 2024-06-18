import java.util.*;

public class QueueArr<E> implements QueueADT <E> {
	private E [] arr;
	private int front, back;
	private int maxSize;
	private final int INITSIZE = 1000;

	public QueueArr() {
		arr = (E []) new Object[INITSIZE]; // create array of E objects
		front = 0; // the queue is empty
		back = 0;
		maxSize = INITSIZE;
	}

	public boolean isEmpty() { 
		return (front == back);        // use solution 2 
	}

	public E peek() { // return the front of the queue 
		// if (isEmpty()) 
        //     return null;
		// else 
        //     return arr[front];
        return isEmpty()? null: arr[front];
	}

	public E poll() {  // remove and return the front of the queue  
		if (isEmpty()) 
            return null;

		E obj = arr[front];
		arr[front] = null;
		front = (front + 1) % maxSize;  // “circular” array
		return obj;
	}

	public boolean offer(E o) {  // add item to the back of the queue
		if (((back+1) % maxSize) == front) // array is full 
			if (!enlargeArr()) 
                return false; // no more memory to
			                                     // enlarge the array
		arr[back] = o;
		back = (back + 1) % maxSize;   // “circular” array
		return true;
	}

	private boolean enlargeArr() {
		int newSize = maxSize * 2;
		E[] x = (E []) new Object[newSize];
		if (x == null) // i.e. no memory allocated to array of E objects
			return false;

		for (int j=0; j < maxSize; j++) {
			// copy the front (1st) element, 2nd element, ..., in the
			// original array to the 1st (index 0), 2nd (index 1), ...,
			// positions in the enlarged array. Q: Why this way?
			x[j] = arr[(front+j) % maxSize];
		}
		front = 0;
		back = maxSize - 1;
		arr = x;
		maxSize = newSize;
		return true;
	}
}