import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {
    final private Node<E> head, tail;
    private int size;

    private static class Node<E>{
        E val;
        Node<E> next;
        Node<E> prev;

        Node(E val){
            this.val = val;
        }
    }

    //constructor function
    public MyLinkedList(){
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    //Create and Add Function
    public void addFirst(E e){
        Node<E> x = new Node<>(e);

        Node<E> temp = head.next;

        temp.prev = x;
        x.next=temp;

        x.prev = head;
        head.next = x;

        size++;
    }

    public void addLast(E e){
        Node<E> x = new Node<>(e);
        Node<E> temp = tail.prev;

        temp.next = x;
        x.prev = temp;

        x.next = tail;
        tail.prev = x;

        size++;
    }
    public void add(int index, E e){
        checkPositionIndex(index);
        if (index == size){
            addLast(e);
            return;
        }

        Node<E> p = getNode(index);
        Node<E> temp = p.prev;
        Node<E> x = new Node<>(e);

        p.prev = x;
        x.next = p;

        temp.next = x;
        x.prev = temp;

        size++;
    }

    //Delete and Remove Function
    public E removeLast(){
        if (size == 0){
            throw new NoSuchElementException();
        }
        Node<E> x = tail.prev;
        Node<E> temp = tail.prev.prev;

        temp.next = tail;
        tail.prev = temp;

        x.prev = null;
        x.next = null;

        size--;
        return x.val;
    }
    public E removeFirst(){
        if (size == 0){
            throw new NoSuchElementException();
        }

        Node<E> x = head.next;
        Node<E> temp = head.next.next;

        head.next = temp;
        temp.prev = head;

        x.prev = null;
        x.next = null;

        size--;
        return x.val;
    }
    public E remove(int index){
        checkElementIndex(index);

        Node<E> x = getNode(index);
        Node<E> prev = x.prev;
        Node<E> next = x.next;

        prev.next = next;
        next.prev = prev;
        x.prev = null;
        x.next = null;

        size--;
        return x.val;
    }

    //Read and Get Function
    public E get(int index){
        checkElementIndex(index);
        Node<E> x = getNode(index);
        return x.val;
    }
    public E getFirst(){
        if (size == 0){
            throw new NoSuchElementException();
        }
        return head.next.val;
    }
    public E getLast(){
        if (size == 0){
            throw new NoSuchElementException();
        }
        return tail.prev.val;
    }

    //Upload and re- Function
    public E set(int index, E val){
        checkElementIndex(index);
        Node<E> x = getNode(index);
        E oldVal = x.val;
        x.val = val;

        return oldVal;
    }

    //Auxiliary and Tool Function
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private Node<E> getNode(int index){
        checkElementIndex(index);
        Node<E> p = head.next;
        for (int i = 0; i< index;i++){
            p = p.next;
        }
        return p;
    }

    private boolean isElementIndex(int index){return index>=0 && index<size;}
    private boolean isPositionIndex(int index){return index>=0 && index<=size;}
    private void checkElementIndex(int index){
        if (!isElementIndex(index)){
            throw new IndexOutOfBoundsException("Index" + index + ", Size:"+size);
        }
    }
    private void checkPositionIndex(int index){
        if (!isPositionIndex(index)){
            throw new IndexOutOfBoundsException("Index" + index + ", Size:"+size);
        }
    }

    private void display(){
        System.out.println("size = "+size);
        for (Node<E> p = head.next; p!=tail;p=p.next){
            System.out.println(p.val+"->");
        }
        System.out.println("null");
        System.out.println();
    }

    /**
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
