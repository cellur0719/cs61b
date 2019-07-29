import java.util.*;
import java.util.Iterator;

public class ArraySet<T> implements Iterable<T>{

    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for(int i = 0; i < size; i++){
            if (items[i].equals(x)) return true;
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map. 
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if(x == null) {
            return;
        }
        if (contains(x)) return;
        items[size] = x;
        size ++;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    /* Returns an iterator (a.k.a seer) into me. */

    public Iterator<T> iterator(){
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T>{
        private int WizPos;
        private ArraySetIterator(){
            WizPos = 0;
        }
        public boolean hasNext(){
            return WizPos < size;
        }
        public T next(){
            T returnItem = items[WizPos];
            WizPos ++;
            return returnItem;
        }
    }
    /*
    @Override
    public String toString(){
        StringBuilder returnSB = new StringBuilder("{");
        for(int i = 0; i < size - 1; i++){
            returnSB.append(items[i].toString());
            returnSB.append(", ");
        }
        returnSB.append(items[size - 1]);
        returnSB.append("}");
        return returnSB.toString();
    }*/

    @Override
    public String toString(){
        List<String> ListOfItems = new ArrayList<String>();
        for(T x : this){
            ListOfItems.add(x.toString());
        }
        return "{" + String.join(", ",ListOfItems) + "}";
    }



    @Override
    public boolean equals(Object item){
        if (item == this) {
            return true;
        }
        if (item == null) {
            return false;
        }
        if (item.getClass() != this.getClass()) {
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) item;
        if(o.size() != this.size()) {
            return false;
        }
        for(T i : this){
            if (!o.contains(i)){
                return false;
            }
        }
        return true;


    }

    public static <Glerk> ArraySet<Glerk> of(Glerk... Stuff){
        ArraySet<Glerk> returnSet  = new ArraySet<Glerk>();
        for (Glerk x : Stuff){
            returnSet.add(x);
        }
        return returnSet;
    }

    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        s.add(null);
        s.add(3);
        s.add(5);
        s.add(7);
        s.add(9);
        Iterator<Integer> seer = s.iterator();
        while(seer.hasNext()){
            System.out.println(seer.next());
        }
        System.out.println();

        ArraySet<Integer> as = new ArraySet<>();
        as.add(null);
        as.add(3);
        as.add(5);
        as.add(7);
        as.add(9);
        ArraySet<Integer> as2 = new ArraySet<>();
        as2.add(null);
        as2.add(3);
        as2.add(5);
        as2.add(7);
        as2.add(9);
        Iterator<Integer> seer2 = as.iterator();

        while(seer2.hasNext()){
            System.out.println(seer2.next());
        }
        System.out.println();

        for (int i : as){
            System.out.println(i);
        }

        System.out.println(as.toString());
        System.out.println(as.equals(null));
        System.out.println(as.equals("fish"));
        System.out.println(as.equals(as));

        ArraySet<String> aSetOfStrings = ArraySet.of("hi", "I'm", "here");
        System.out.println(aSetOfStrings);
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}