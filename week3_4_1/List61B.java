public interface List61B<T> {

    void addLast(T x);

    void addFirst(T x);

    T getFirst();

    T getLast();

    void insert(T item, int position);

    int size();

    T get(int index);

    default public void print(){
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    public static void peek(List61B<String> list) {
        System.out.println(list.getLast());
    }
    public static void peek(SLList<String> list) {
        System.out.println(list.getFirst());
    }
}
