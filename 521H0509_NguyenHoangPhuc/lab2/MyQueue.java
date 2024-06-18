public class MyQueue<E> implements QueueInterface<E> {
    private Node<E> front = null;
    private Node<E> rear = null;
    private int numNode = 0;

    @Override
    public void enQueue(E item) {
        // TODO Auto-generated method stub
        if (front == null) {
            front = new Node<>(item, front);
            numNode++;
        } else {
            rear = new Node<>(item, null);
            Node<E> n = front;
            while (n.getNext() != null) {
                n = n.getNext();
            }
            n.setNext(rear);
            numNode++;
        }

    }

    @Override
    public E deQueue() {
        if (front == null)
            return null;
        Node<E> n = front;
        front = front.getNext();
        numNode--;
        return n.getElement();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return numNode;
    }

    @Override
    public boolean contains(E item) {
        Node<E> n = front;
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
        Node<E> n = front;
        // TODO Auto-generated method stub
        while (n != null) {
            System.out.println(n.getElement());
            n = n.getNext();
        }

    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return (numNode == 0);
    }

    @Override
    public E getFront() {
        // TODO Auto-generated method stub
        return (front == null) ? null : front.getElement();
    }

}
