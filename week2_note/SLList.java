/** An SLList is a list of integers, which hides the grim truth
 * of nakedness within. */

 public class SLList{

 	public static class IntNode{
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n){
			item = i;
			next = n;
		}
	}

 	private IntNode sentinel;
 	private int size;

 	public SLList(){
 		size = 0;
 		sentinel = new IntNode(63, null);
 	}

 	public SLList(int x){
 		sentinel = new IntNode(63, null);
 		sentinel.next = new IntNode(x, null);
 		size = 1;
 	}

 	public void addFirst(int x){
 		sentinel.next = new IntNode(x, sentinel.next);
 		size ++;
 	}

 	public void addLast(int x){
 		IntNode p = sentinel;

 		/*Move p until it reaches the end of the list. */
 		while(p.next != null){
 			p = p.next;
 		}
 		p.next = new IntNode(x, null);
 		size++;
 	}

 	public int getFirst(){
 		int f  = sentinel.next.item;
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
 		SLList L = new SLList(1);
 		//System.out.println(L.getFirst());
 		//L.addFirst(5);
 		L.addLast(15);
 		L.addFirst(10);
 		L.addFirst(10);
 		System.out.println(L.size());
 		//System.out.println(L.getFirst());
 	}
 }