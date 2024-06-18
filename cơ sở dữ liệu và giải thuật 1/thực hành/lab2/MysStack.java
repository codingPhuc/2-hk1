import java.util.*;

public class MysStack<E> implements StackInterface<E> {
    private Node<E> top = null;
    private int number = 0;

    /*
     * (non-Javadoc)
     * 
     * @see StackInterface#push(java.lang.Object)
     */
    @Override
    public void push(E x) {
        top = new Node<E>(x, top);
        number++;
    }

    @Override
    public E pop() throws NoSuchElementException {
        Node<E> ln = null;
        if (top == null) {
            throw new NoSuchElementException("there is no head");
        } else {
            ln = top;
            top = top.getNext();
            number--;
            return ln.getElement();
        }
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return number;
    }

    @Override
    public boolean contains(E item) {
        Node<E> n = top;
        if (isEmpty())
            return false;
        while (n != null) {
            if (n.getElement().equals(item))
                return true;
            n = n.getNext();
        }
        return false;
    }

    @Override
    public void print() {
        Node<E> n = top;
        // TODO Auto-generated method stub
        while (n != null) {
            System.out.println(n.getElement());
            n = n.getNext();
        }

    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method
        return (number == 0);
    }

    @Override
    public E getPeek() {
        if (isEmpty())
            return null;
        return top.getElement();
    }

}
