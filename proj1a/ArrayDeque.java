public class ArrayDeque<T>{
	private T[] items;
	private int size;

	public ArrayDeque(){
		items = (T[]) new Object[8];
		size = 0;
	}

	public void resize(int s){
		T[] a = (T[]) new Object[s];
		System.arraycopy(items, 0, a, 0, size);
		items = a;
	}

	public void addFirst(T item){ 
		T[] a = (T[]) new Object[size];
		if(size == items.length){
			a = (T[]) new Object[size * 2];
		}
		System.arraycopy(items, 0, a, 1, size);
		a[0] = item;
		items = a;
		size++;
	}

	public void addLast(T item){
		if(size == items.length){
			resize(size * 2);
		}
		items[size] = item;
		size++;
	}

	public boolean isEmpty(){
		if(size == 0) return true;
		else return false;
	}

	public int size(){
		return size;
	}

	public void printDeque(){
		for(int i = 0; i < size; i++){
			System.out.print(items[i] + " ");
		}
		System.out.println();
	}

	public T removeFirst(){
		T[] a = (T[]) new Object[size];
		T x = items[0];
		System.arraycopy(items, 1, a, 0, size - 1);
		items = a;
		size--;
		return x;
	}

	public T removeLast(){
		if(items.length >= 16 && size * 1.0 / items.length <= 0.25){
			T[] a = (T[]) new Object[size];
			System.arraycopy(items, 0, a, 0, size);
			items = a;
		}
		T x = items[size - 1];
		items[size - 1] = null;
		size--;
		return x;
	}

	public T get(int index){
		return items[index];
	}

	public ArrayDeque(ArrayDeque<T> other){
		items = (T[]) new Object[8];
		size = 0;
		for(int i = 0; i < other.size(); i++){
            addLast((T) other.get(i));
        }
	}
}