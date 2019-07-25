public class AList<T> implements List61B<T> {

    private T[] list;
    private int size;
    /** Creates an empty list. */
    public AList() {
        list = (T[])new Object[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    @Override
    public void addLast(T x) {
        list[size++] = x;
    }

    @Override
    public void addFirst(T x){
       for (int i = size; i > 0; i--) {
           list[i] = list[i - 1];
       }
       list[0] = x;
       size++;
    }

    @Override
    public T getFirst(){
        return list[0];
    }

    @Override
    public T getLast(){
        return list[size - 1];
    }

    @Override
    public void insert(T item, int position){
        if (position >= size) {
            list[size] = item;
        } else {
            for (int i = size; i > position; i--){
                list[i] = list[i - 1];
            }
            list[position] = item;
        }
        size++;
    }

    /** Returns the item from the back of the list. */

    /** Gets the ith item in the list (0 is the front). */
    @Override
    public T get(int i) {
        return list[i];        
    }

    /** Returns the number of items in the list. */
    @Override
    public int size() {
        return size;        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public T removeLast() {
        T rtn = list[size - 1];
        size = size - 1;
        //No need to set list[size - 1] = 0.
        return rtn;
    }

    @Override
    public void print(){
        System.out.println("This uses the print method inside AList");
        for (int i = 0; i < size; i++){
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}