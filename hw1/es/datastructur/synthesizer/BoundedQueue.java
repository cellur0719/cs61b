package es.datastructur.synthesizer;
import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T>{

    int capacity();

    int fillCount();

    void enqueue(T x);

    T dequeue();

    T peek();

    default boolean isEmpty(){
        int fillC = fillCount();
        return(fillC == 0);
    }

    default boolean isFull(){
        int fillC = fillCount();
        int capacity = capacity();
        return (fillC == capacity);
    }

    Iterator<T> iterator();

    boolean equals(Object o);






}
