import java.util.*;

class MyQueue_2Stack_EX6<E> implements QueueInterface<E> {
    private MysStack<E> s1 = new MysStack<>();
    private MysStack<E> s2 = new MysStack<>();

    @Override
    public void enQueue(E x) {

        while (!s1.isEmpty()) {
            s2.push(s1.pop());

        }
        s1.push(x);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    @Override
    public E deQueue() {

        if (s1.isEmpty()) {
            System.out.println("Q is Empty");
            return null;
        }

        E x = s1.getPeek();
        s1.pop();
        return x;
    }

    @Override
    public void print() {
        s1.print();
    }

    @Override
    public int size() {
        return s1.size();
    }

    @Override
    public boolean contains(E item) {
        return (s1.contains(item));
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return s1.isEmpty();
    }

    @Override
    public E getFront() {
        // TODO Auto-generated method stub
        return s1.getPeek();
    }

}