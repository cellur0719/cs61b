public interface Deque<T> {
    //接口内方法修饰符一定为public，故均可省略为默认
    void addFirst(T item);

    void addLast(T item);

    boolean isEmpty();

    int size();

    void printDeque();

    T removeFirst();

    T removeLast();

    T get(int index);
}
