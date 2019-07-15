
public class LinkedListDeque<T> {

    private class StuffNode{
        private T item;
        private StuffNode next;
        private StuffNode prev;

        private StuffNode(T i, StuffNode n, StuffNode p){
            item = i;
            next = n;
            prev = p;
        }

        private StuffNode(){
            item = null;
            next = null;
            prev = null;
        }

    }
    private int size;
    private StuffNode sentinel;

    public LinkedListDeque(){
        size = 0;
        sentinel = new StuffNode();
        sentinel.next = sentinel.prev = sentinel;

    }

    public void addFirst(T item){
        StuffNode newNode = new StuffNode(item, sentinel.next, sentinel);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(T item){
        StuffNode newNode = new StuffNode(item, sentinel, sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    public boolean isEmpty(){
        if(size == 0) return true;
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        StuffNode p = sentinel;
        for(int i = 0; i < size; i++){
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.print("\n");
    }

    public T removeFirst(){
        T result = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return result;
    }

    public T removeLast(){
        T result = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return result;
    }

    public T get(int index){
        if(index > size - 1) return null;
        StuffNode p = sentinel;
        for(int i = 0; i <= index; i++){
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index){
        if(index > size - 1) return null;
        if(index == 0){
            return sentinel.next.item;
        }
        else{
            LinkedListDeque<T> newLLD = new LinkedListDeque<>();
            newLLD.sentinel = sentinel.next;
            newLLD.sentinel.next = sentinel.next.next;
            newLLD.sentinel.prev = sentinel;
            return newLLD.getRecursive(index-1);
        }
    }

    public LinkedListDeque(LinkedListDeque<T> other){
        sentinel = new StuffNode();
        sentinel.prev = sentinel.next = sentinel;
        size = 0;

        for(int i = 0; i < other.size(); i++){
            addLast((T) other.get(i));
        }
    }
}