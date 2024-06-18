import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ListInterface<E> {
  private Node<E> head;
  private int numNode;

  public MyLinkedList() {
    head = null;
    numNode = 0;
  }

  @Override
  public void addFirst(E item) {
    head = new Node<E>(item, head);
    numNode++;
  }

  @Override
  public void addAfter(Node<E> curr, E item) {
    if (curr == null) {
      addFirst(item);
    } else {
      Node<E> newNode = new Node<E>(item, curr.getNext());
      curr.setNext(newNode);
    }
    numNode++;
  }

  @Override
  public void addLast(E item) {
    if (head == null) {
      addFirst(item);
    } else {
      Node<E> tmp = head;
      while (tmp.getNext() != null) {
        tmp = tmp.getNext();
      }
      Node<E> newNode = new Node<>(item, null);
      tmp.setNext(newNode);
      numNode++;
    }
  }

  @Override
  public E removeFirst() throws NoSuchElementException {
    if (head == null) {
      throw new NoSuchElementException("Can't remove element from an empty list ");
    } else {
      Node<E> tmp = head;
      head = head.getNext();
      numNode--;
      return tmp.getData();
    }
  }

  @Override
  public E removeAfter(Node<E> curr) throws NoSuchElementException {
    if (curr == null) {
      throw new NoSuchElementException("Can't remove element from an empty list ");
    } else {
      Node<E> delNode = curr.getNext();
      if (delNode != null) {
        curr.setNext(delNode.getNext());
        numNode--;
        return delNode.getData();
      } else {
        throw new NoSuchElementException("No next node to remove ");
      }
    }
  }

  @Override
  public E removeLast() throws NoSuchElementException {
    if (head == null) {
      throw new NoSuchElementException("Can't remove element from an empty list ");
    } else {
      Node<E> preNode = null;
      Node<E> delNode = head;
      while (delNode.getNext() != null) {
        preNode = delNode;
        delNode = delNode.getNext();
      }
      preNode.setNext(delNode.getNext());
      delNode.setNext(null);
      numNode--;
      return delNode.getData();
    }
  }

  @Override
  public void print() {
    if (head != null) {
      Node<E> tmp = head;
      System.out.print("List: " + tmp.getData());
      tmp = tmp.getNext();
      while (tmp != null) {
        System.out.print(" -> " + tmp.getData());
        tmp = tmp.getNext();
      }
      System.out.println();
    } else {
      System.out.println("List is empty!");

    }
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    if (numNode == 0)
      return true;
    return false;
  }

  @Override
  public E getFirst() throws NoSuchElementException {
    if (head == null) {
      throw new NoSuchElementException("Can't get element from an empty list");
    }
    return null;
  }

  @Override
  public Node<E> getHead() {
    // TODO Auto-generated method stub
    return head;
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return numNode;
  }

  @Override
  public boolean contains(E item) {
    Node<E> tmp = head;
    while (tmp != null) {
      if (tmp.getData().equals(item))
        return true;
      tmp = tmp.getNext();
    }
    return false;
  }

  // excersise 2
  public E removeCurr(Node<E> curr) throws NoSuchElementException {
    if (isEmpty()) {
      return null;
    }
    Node<E> then, now;
    E found = null;
    for (then = null, now = head; now != null; then = now, now = now.getNext()) {
      if (curr.getData().equals(now.getData()) && then != null) {
        then.setNext(now.getNext());
        found = now.getData();
        numNode--;

      } else if (curr.getData().equals(now.getData()) && then == null) {
        found = head.getData();
        head = now.getNext();
      }
    }
    return found;
  }
  // excersise 3

  public E addItem(Node<E> curr) {
    Node<E> found = null;
    for (Node<E> n = head, p = null; n != null; p = n, n = n.getNext()) {
      if ((Integer) n.getData() % 2 == 0) {
        found = n;
        p.setNext(curr);
        curr.setNext(n);
        break;
      }

    }
    return found.getData();
  }

  public int countEven() {
    if (isEmpty())
      return 0;
    int count = 0;
    Node<E> n = head;
    while (n != null) {
      if ((Integer) n.getData() % 2 == 0) {
        count++;
      }
      n = n.getNext();
    }
    return count;
  }

  public static boolean checkPrime(int n) {
    if (n < 2)
      return true;
    for (int i = 2; i <= n / 2; i++) {
      if (n % i == 0)
        return false;
    }
    return true;
  }

  public int countPrime() {
    int count = 0;
    Node<E> n = head;

    while (n != null) {

      if (checkPrime((Integer) n.getData())) {
        count = count + 1;
      }
      n = n.getNext();
    }
    return count;
  }

  public int maxNum() {
    int Max = (Integer) head.getData();
    Node<E> n = head.getNext();
    while (n != null) {
      if ((Integer) n.getData() > Max) {
        Max = (Integer) n.getData();
      }
      n = n.getNext();
    }
    return Max;
  }

  public void sortList() {
    // Node current will point to head
    Node<E> current = head, index = null;
    E temp;

    if (head == null) {
      return;
    } else {
      while (current != null) {
        index = current.getNext();

        while (index != null) {

          if ((Integer) current.getData() > (Integer) index.getData()) {
            temp = current.getData();
            current.setData(index.getData());
            index.setData(temp);
          }
          index = index.getNext();
        }
        current = current.getNext();
      }
    }
  }

  public void revestList() {
    Node<E> prev, next, n;
    // n = head;
    // for (prev = null, next = null, n = head; n != null; prev = n, n = next) {
    // next = n.getNext();
    // n.setNext(prev);
    // }
    n = head;
    prev = null;
    next = null;
    while (n != null) {
      next = n.getNext();
      n.setNext(prev);
      prev = n;
      n = next;
    }
    head = prev;
  }

}
