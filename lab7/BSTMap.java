import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BSTMap<K extends Comparable, V> implements Map61B<K, V> {
    int size;
    K key;
    V value;
    BSTMap<K, V> left;
    BSTMap<K, V> right;


    public BSTMap(){
        size = 0;
        key = null;
        value = null;
        left = null;
        right = null;
    }

    public BSTMap(K k, V v){
        size = 1;
        this.key = k;
        this.value = v;
        left = null;
        right = null;
    }

    public void clear(){
        size = 0;
        key = null;
        value = null;
        left = null;
        right = null;
    }



    /* Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K k){
        BSTMap p = this;
        if (size == 0){
            return false;
        }
        while(p != null){
            if(k.compareTo(p.key) < 0){
                p = p.left;
            } else if(k.compareTo(p.key) > 0){
                p = p.right;
            } else {
                return true;
            }
        }
        return false;
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K k){
        BSTMap p = this;
        if (size == 0) {
            return null;
        }
        while(p != null){
            if(k.compareTo(p.key) < 0){
                p = p.left;
            } else if(k.compareTo(p.key) > 0){
                p = p.right;
            } else {
                return (V) p.value;
            }
        }
        return null;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size(){
        return size;
    }

    /* Associates the specified value with the specified key in this map. */
    public void put(K k, V v){
        if (containsKey(k)) {
            return ;
        }
        if (size == 0) {
            this.key = k;
            this.value = v;
            size++;
            return;
        }
        BSTMap p = this;
        while (p.left != null || p.right != null) {
            if (k.compareTo(p.key) < 0){
                if (p.left == null) {
                    p.left = new BSTMap(k, v);
                    size++;
                    return;
                } else {
                    p = p.left;
                }

            } else{
                if(p.right == null) {
                    p.right = new BSTMap(k, v);
                    size++;
                    return;
                } else {
                    p = p.right;
                }

            }
        }
        if(k.compareTo(p.key) < 0) {
            p.left = new BSTMap(k, v);
        } else {
            p.right = new BSTMap(k, v);
        }
        size++;

    }

    /* Returns a Set view of the keys contained in this map. */
    public Set<K> keySet(){
        throw new UnsupportedOperationException();
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException. */
    public V remove(K key){
        throw new UnsupportedOperationException();
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    public V remove(K key, V value){
        throw new UnsupportedOperationException();
    }

    public Iterator<K> iterator(){
        //return new BSTMapIterator();
        throw new UnsupportedOperationException();
    }
    /*
    private class  BSTMapIterator() implements Iterator<K>{

    }*/

    public void printInOrder() {
        printInOrder(this);
    }
    private void printInOrder(BSTMap m) {
        if (m == null) {
           return;
        }
        printInOrder(m.left);
        System.out.println(m.key + "+" + m.value);
        printInOrder(m.right);

    }
}
