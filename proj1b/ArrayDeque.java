public class ArrayDeque<T> implements Deque<T>{
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

	@Override
	public void addFirst(T item){ 
		T[] a = (T[]) new Object[items.length];
		int s = Math.max(size * 2, 1);
		if(size == items.length){
			a = (T[]) new Object[s];
		}
		System.arraycopy(items, 0, a, 1, size);
		a[0] = item;
		items = a;
		size++;
	}

	@Override
	public void addLast(T item){
		if(size == items.length){
			int s = Math.max(size * 2, 1);
			resize(s);
		}
		items[size] = item;
		size++;
	}

	@Override
	public boolean isEmpty(){
		if(size == 0) return true;
		else return false;
	}

	public int size(){
		return size;
	}

	@Override
	public void printDeque(){
		for(int i = 0; i < size; i++){
			System.out.print(items[i] + " ");
		}
		System.out.println();
	}

	@Override
	public T removeFirst(){
		T[] a = (T[]) new Object[size];
		T x = items[0];
		int s = Math.min(size - 1, 1);
		System.arraycopy(items, s, a, 0, size - 1);
		items = a;
		size--;
		return x;
	}

	@Override
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

	@Override
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