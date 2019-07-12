/** An SLList is a list of integers, which hides the grim truth
 * of nakedness within. */

 public class genericList<LochNess>{

 	public class StuffNode{
		public LochNess item;
		public StuffNode next;

		public StuffNode(LochNess i, StuffNode n){
			item = i;
			next = n;
		}
	}

 	private StuffNode first;
 	private int size;


 	public genericList(LochNess x){
 		first = new StuffNode(x, null);
 		size = 1;
 	}

 	public void addFirst(LochNess x){
 		first = new StuffNode(x, first);
 		size ++;
 	}

 	public void addLast(LochNess x){
 		StuffNode p = first;

 		/*Move p until it reaches the end of the list. */
 		while(p.next != null){
 			p = p.next;
 		}
 		p.next = new StuffNode(x, null);
 		size++;
 	}

 	public LochNess getFirst(){
 		LochNess f  = first.item;
 		return f;
 	}

 	/*Returns the size of the list that starts at the IntNode p. */

 	/*
 	private static int size(IntNode p){
 		if(p.next == null) return 0;
 		return size(p.next) + 1;
 	}

 	public int size(){
 		return size(sentinel);
 	}
 	*/

 	public int size(){
 		return size;
 	}
 	

 	public static void main(String[] args) {
 		genericList<String> L = new genericList<>("believe");
 		//System.out.println(L.getFirst());
 		//L.addFirst(5);
 		L.addLast("yourself");
 		L.addFirst("should");
 		L.addFirst("You");
 		System.out.println(L.size());
 		//System.out.println(L.getFirst());
 	}
 }