/** An SLList is a list of T types, which hides the grim truth
 * of nakedness within. */

 public class SLList<T> implements List61B<T>{

 	public class StuffNode{
		public T item;
		public StuffNode next;

		public StuffNode(T i, StuffNode n){
			item = i;
			next = n;
		}
	}

 	public StuffNode first;
 	private int size;

 	public SLList(){
 		first = null;
 		size = 0;
 	}

 	public SLList(T x){
 		first = new StuffNode(x, null);
 		size = 1;
 	}

	@Override
 	public void addFirst(T x){
 		first = new StuffNode(x, first);
 		size++;
 	}

	@Override
 	public void addLast(T x){
 		if(size == 0){
 			first = new StuffNode(x, first);
		} else {
			StuffNode p = first;
			while(p.next != null){
				p = p.next;
			}
			p.next = new StuffNode(x, p.next);
		}
 		size++;
	}

	@Override
 	public void insert(T item, int position){
 		StuffNode p  = first;
 		for (int i = 0; i < position - 1; i++) {
 			if(p.next == null) break;
 			p = p.next;
 		}
 		p.next = new StuffNode(item, p.next);
 		size++;
 	}

	@Override
 	public int size(){
 		return size;
 	}

	@Override
 	public T get(int index){
 		StuffNode p = first;
 		for (int i = 0; i < index; i++) {
 			p = p.next;
 		}
 		return p.item;
 	}

 	public void reverse(){
 		if(first == null || first.next == null) return;
 		StuffNode p = first.next;
 		first.next = null;
 		while(p != null){
 			StuffNode temp = p.next;
 			p.next = first;
 			first = p;
 			p = temp;
 		}
 	}

 	public void reverseRecur(){
 		first = reverseHelp(first);
 	}

 	public StuffNode reverseHelp(StuffNode c){
 		if(c == null || c.next == null) return c;
 		else{
 			StuffNode temp = c.next;
 			StuffNode rtn = reverseHelp(c.next);
 			temp.next = c;
 			c.next = null;
 			return rtn;

 		}
 	}

 	@Override
 	public T getFirst(){
 		return first.item;
	}

	@Override
	public T getLast(){
 		StuffNode p = first;
 		while(p.next != null){
 			p = p.next;
		}
 		return p.item;
	}

 	@Override
 	public void print(){
 		System.out.println("This uses the print method inside SLList");
 		for (StuffNode p = first; p != null; p = p.next){
 			System.out.print(p.item + " ");
		}
 		System.out.println();
	}

}
