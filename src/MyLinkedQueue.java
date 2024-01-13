public class MyLinkedQueue<E> {
    private MyLinkedList<E> list = new MyLinkedList<>();

    //队尾添加元素
    public void offer(E e){
        list.addLast(e);
    }

    //对头弹出元素
    public E poll(){
        return list.removeFirst();
    }

    //查看对头元素
    public E peekFirst(){
        return list.getFirst();
    }

    public E peekLast(){
        return list.getLast();
    }
}
