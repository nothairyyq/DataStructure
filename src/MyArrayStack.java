import java.util.NoSuchElementException;

public class MyArrayStack<E> {
    private MyArrayList<E> arr = new MyArrayList<>();

    public void push(E e){
        arr.addLast(e);
    }

}
