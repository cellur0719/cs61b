package bearmaps;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T> {


    private ArrayList<priorityNode> items;

    public ArrayHeapMinPQ(){
        items = new ArrayList<>();
    }

    public void add(T item, double priority) {
        if (contains(item)) {
            throw new IllegalArgumentException();
        }
        items.add(new priorityNode(item, priority));
        swim(items.size() - 1);
    }

    private void swim(int k) {
        priorityNode parent = items.get(parent(k));
        if (parent.compareTo(items.get(k)) > 0) {
            swap(parent(k), k);
            swim(parent(k));
        }
    }

    private int parent(int k) {
        return (k - 1) / 2;
    }
    private void swap(int p, int q) {
        priorityNode temp = items.get(p);
        items.set(p, items.get(q));
        items.set(q, temp);
    }

    public boolean contains(T item) {
        return items.contains(new priorityNode(item, 0));
    }

    public T getSmallest() {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        priorityNode root = items.get(0);
        return root.getItem();
    }

    public T removeSmallest() {
        if(items.size() == 0) {
            throw new NoSuchElementException();
        }
        T smallest = items.get(0).getItem();
        swap(0, items.size() - 1);
        items.remove(items.size() - 1);
        sink(0);
        return smallest;
    }

    private void sink(int k) {
        int minIndex;
        if ((k * 2 + 1) > this.size() - 1) {
            return;
        }
        if (k * 2 + 2 <= this.size() - 1){
            if (items.get(k * 2 + 1).compareTo(items.get(k * 2 + 2)) < 0) {
                minIndex = k * 2 + 1;
            }else {
                minIndex = k * 2 + 2;
            }
            if (items.get(k).compareTo(items.get(minIndex)) > 0) {
                swap(k, minIndex);
                sink(minIndex);
            }
        }
        if (items.get(k).compareTo(items.get(k * 2 + 1)) > 0) {
            swap(k, k * 2 + 1);
            sink(k * 2 + 1);
        }
    }

    public int size() {
        return items.size();
    }

    public void changePriority(T item, double priority){
        if (!contains(item)) {
            throw new NoSuchElementException();
        }
        items.get(indOf(item)).setPriority(priority);
        swim(indOf(item));
    }

    private int indOf(T item) {
        return items.indexOf(new priorityNode(item, 0));
    }

    private class priorityNode implements Comparable<priorityNode>{
        private T item;
        private double priority;

        priorityNode(T i, double p) {
            this.item = i;
            this.priority = p;
        }

        T getItem() {
            return item;
        }

        double getPriority() {
            return priority;
        }

        void setPriority(double p) {
            this.priority = p;
        }

        @Override
        public int compareTo(priorityNode o) {
            if (o == null) {
                return -1;
            }
            return Double.compare(this.getPriority(), o.getPriority());
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || o.getClass() != this.getClass()) {
                return false;
            }
            return this.getItem() == ((priorityNode) o).getItem();
        }

        @Override
        public int hashCode() {
            return item.hashCode();
        }

    }
}
