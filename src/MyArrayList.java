import java.util.Iterator;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements Iterable<E> {
    private E[] data;
    private int size;
    private static final int INIT_CAP = 1;


    public MyArrayList(){
        this(INIT_CAP);
    }

    public MyArrayList(int initCap) {
        data = (E[]) new Object[initCap];
        size = 0;
    }

    //add function: addLast, add, addFirst
    public void addLast(E e){
        int cap = data.length;
        if (size == cap){
            resize(cap*2);
        }
        data[size] = e;
        size++;
    }
    public void add(int index, E e){
        checkPositionIndex(index);

        int cap = data.length;
        if (size == cap){
            resize(cap*2);
        }

        System.arraycopy(data,index,data,index+1,size-index);
        data[index] = e;
        size++;
    }
    public void addFirst(E e){
        add(0,e);
    }

    //Delete Function: removeLast(), remove(index), removeFirst()
    public E removeLast(){
        if (size == 0){
            throw new NoSuchElementException();
        }

        int cap = data.length;

        if (size == cap/4){
            resize(cap/2);
        }

        E removeVal = data[size-1];
        data[size-1] = null;
        size-=1;

        return  removeVal;
    }

    public E remove(int index){
        checkPositionIndex(index);
        int cap = data.length;
        if (size == cap/4){
            resize(cap/2);
        }

        E removeVal = data[index];
        System.arraycopy(data,index+1,data,index,size-index-1);
        data[size-1] = null;
        size--;
        return removeVal;
    }

    public E removeFirst(){
        return remove(0);
    }

    //Read Function: get(index)
    public E get(int index){
        checkPositionIndex(index);
        return data[index];
    }

    //Update Function: set(index, element)
    public E set(int index, E element){
        checkPositionIndex(index);
        E oldVal = data[index];
        data[index] = element;
        return oldVal;
    }

    //Auxiliary Function
    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    //enlarge data size to new capacity
    private void resize(int newCap){
        if (size > newCap){
            return;
        }
        E[] temp = (E[]) new Object[newCap];
        for (int i = 0; i<size; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    //check index is put element
    private void checkPositionIndex(int index){
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: "+ size);
    }

    //check index correct;
    private boolean isPositionIndex(int index){
        return index >= 0 && index <= size;
    }

    private void checkElementIndex(int index){
        if (!isElementIndex(index)){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: "+ size);
        }
    }
    private boolean isElementIndex(int index){ return index >= 0 && index < size; }
    public Iterator<E> iterator(){
        return new Iterator<E>() {
            private int p = 0;
            @Override
            public boolean hasNext() {
                return p != size;
            }

            @Override
            public E next() {
                return data[p++];
            }
        };
    }
    private void display() {
        System.out.println("size = " + size + " cap = " + data.length);
        System.out.println(Arrays.toString(data));
    }


    public static void main(String[] args) {
        // 初始容量设置为 3
        MyArrayList<Integer> arr = new MyArrayList<>(3);

        // 添加 5 个元素
        for (int i = 1; i <= 5; i++) {
            arr.addLast(i);
        }

        arr.remove(3);
        arr.add(1, 9);
        arr.addFirst(100);
        int val = arr.removeLast();

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

}