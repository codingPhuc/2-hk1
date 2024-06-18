import java.util.NoSuchElementException;

public class ListUsingArray<E> implements ListInterface<E> {
    private final int MAX_SIZE = 128;
    private int numNodes;
    private E[] arr;

    public ListUsingArray() {
        numNodes = 0;
        arr = (E[]) new Object[MAX_SIZE];
    }

    @Override
    public boolean isEmpty() {
        return numNodes == 0;
    }

    @Override
    public int size() {
        return numNodes;
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty list");
        }
        return arr[0];
    }

    @Override
    public boolean contains(E item) {
        for(int i = 0; i < numNodes; i++) {
            if (arr[i].equals(item)) { // ==
                return true;
            }
        }
        return false;
    }

    @Override
    public void addFirst(E item) {
        if (numNodes == MAX_SIZE) {
            System.out.println("Full List");
            return;
        }

        for(int i = numNodes; i >= 1; i--) {
            arr[i] = arr[i-1];
        }
        arr[0]= item;
        numNodes++;
    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty list");
        }

        E tmp = arr[0];
        for (int i = 0; i < numNodes - 1; i++) {
            arr[i] = arr[i+1];
        }
        numNodes--;
        return tmp;
    }

    @Override
    public void print() {
        for(int i = 0; i < numNodes; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
    
}
