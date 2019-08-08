import java.util.*;

public class MyHashMap<K, V> implements Map61B<K, V> {

    HashSet<K> HashSet = new HashSet<>();
    Entry<K, V>[] buckets;
    private int bucketSize = 16;
    private double loadFactor = 0.75;
    private int size = 0;

    public MyHashMap() {
        buckets = new Entry[bucketSize];

    }

    public MyHashMap (int initialS) {
        bucketSize = initialS;
        buckets = new Entry[bucketSize];
    }

    public MyHashMap (int initialS, double loadF) {
        bucketSize = initialS;
        loadFactor = loadF;
        buckets = new Entry[bucketSize];


    }

    public void clear() {
        HashSet = new HashSet<>();
        buckets = new Entry[bucketSize];
        size = 0;
    }

    /** Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key) {
        return(get(key) != null);
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K k) {
        int bucketNum = getNum(k);
        Entry e = buckets[bucketNum];
        while(e != null){
            if (e.hashCode() == k.hashCode()) {
                return (V) e.value;
            }
            e = buckets[bucketNum].next;
        }
        return null;
    }

    /** Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key,
     * the old value is replaced.
     */
    public void put(K k, V v) {
        if(containsKey(k)){
            size--;
        }
        int bucketNum;
        Entry e;
        size++;
        HashSet.add(k);
        if(size >= buckets.length * loadFactor) {

            Entry<K, V>[] buckets2 = new Entry[buckets.length * 2];
            Iterator<K> iter = HashSet.iterator();
            while(iter.hasNext()) {
                K next = iter.next();
                V nextValue = get(next);
                bucketNum = (next.hashCode() & 0x7FFFFFFF) % buckets2.length;
                if (buckets2[bucketNum] == null) {
                    buckets2[bucketNum] = new Entry(k, v, null);
                } else {
                    buckets2[bucketNum].put(next, nextValue);
                }

            }
            buckets = buckets2;
            bucketSize *= 2;

        }
        bucketNum = getNum(k);
        if(buckets[bucketNum] == null) {
            buckets[bucketNum] = new Entry(k, v, null);
        } else {
            buckets[bucketNum].put(k, v);
        }

    }

    /** Returns a Set view of the keys contained in this map. */
    public Set<K> keySet() {
        return HashSet;
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException.
     */
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /**
     * Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.
     */
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    public Iterator<K> iterator() {
        return HashSet.iterator();
    }

    private int getNum(K k) {
        return (k.hashCode() & 0x7FFFFFFF) % bucketSize;
    }

    private static class Entry<K, V> implements Map.Entry<K, V> {
        K key;
        V value;
        Entry next;

        Entry(K k, V v, Entry n) {
            this.key = k;
            this.value = v;
            this.next = n;
        }
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V x) {
            V oldValue = getValue();
            this.value = x;
            return oldValue;
        }

        public int hashCode()  {
            return key.hashCode();
        }

        public boolean equals(Object o) {
            if (o.getClass() != this.getClass()) {
                return false;
            }
            Entry<K, V> oo = (Entry<K, V>) o;
            return oo.hashCode() == this.hashCode();
        }

        public void put(K k, V v){
            Entry p = this;
            while(p.next != null && p.key != k) {
                p = p.next;
            }
            if (p.key == k) {
                p.value = v;
                return;
            }
            p.next = new Entry(k, v, null);
        }
    }
}
