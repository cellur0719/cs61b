public class VengefulSLList<T> extends SLList<T> {

    SLList<T> deletedItems;
    /*
    public VengefulSLList(){
        deletedItems = new SLList<T>();
    }
    */

    public VengefulSLList(){
        deletedItems = new SLList<>();
    }

    public VengefulSLList(T x){
        super(x);
        deletedItems = new SLList<>();
    }

    @Override
    public T removeLast(){
        T x = super.removeLast();
        deletedItems.addLast(x);
        return x;
    }

    public void printLostItems() {
        deletedItems.print();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vs1 = new VengefulSLList<>(0);
        vs1.addLast(1);
        vs1.addLast(5);
        vs1.addLast(10);
        vs1.addLast(13);
        vs1.removeLast();
        vs1.removeLast();
        vs1.printLostItems();
    }
}
