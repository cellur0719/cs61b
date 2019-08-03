package es.datastructur.synthesizer;
import java.util.Iterator;

//TODO: Make sure to that this class and all of its methods are public
//TODO: Make sure to add the override tag for all overridden methods
//TODO: Make sure to make this class implement BoundedQueue<T>

public class ArrayRingBuffer<T> implements BoundedQueue<T>{
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity){
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
    }

    @Override
    public int capacity(){
        return rb.length;
    }

    @Override
    public int fillCount(){
        return fillCount;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update
        //       last.
        if (fillCount == rb.length) {
            throw new RuntimeException("Ring Buffer overflow");
        }
        if (last == rb.length - 1) {
            rb[0] = x;
            last = 0;
        } else if(fillCount == 0) {
            rb[last] = x;

        } else{
            rb[last + 1] = x;
            last++;
        }
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and
        //       update first.
        if (fillCount == 0) {
            throw new RuntimeException("Ring Buffer underflow");
        }
        T rtn = rb[first];
        rb[first] = null;
        if (first == rb.length - 1) {
            first = 0;
        } else {
            first++;
        }
        fillCount--;
        return rtn;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should
        //       change.
        return rb[first];
    }

    // TODO: When you get to part 4, implement the needed code to support
    //       iteration and equals.

    @Override
    public Iterator<T> iterator(){
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<T>{
        private int pos;
        private int count;

        public ArrayRingBufferIterator(){
            pos = first;
            count = 0;
        }

        public boolean hasNext(){
            return count < fillCount;
        }

        public T next(){
            T returnItem = rb[pos];
            if(pos == rb.length - 1) {
                pos =0;
            } else {
                pos++;
            }
            count++;
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object o){
        if (o.getClass() != this.getClass()) {
            return false;
        }
        ArrayRingBuffer oo = (ArrayRingBuffer) o;
        if(oo.fillCount != this.fillCount){
            return false;
        }
        int pos = first;
        for (int i = 0; i < fillCount(); i++){
            T itemOfO = (T) oo.dequeue();
            if(itemOfO != rb[pos]) {
                return false;
            }
            if (pos == rb.length - 1) {
                pos = 0;
            } else {
                pos++;
            }
        }
        return true;
    }
}
    // TODO: Remove all comments that say TODO when you're done.


