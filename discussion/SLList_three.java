/** An SLList is a list of integers, which hides the grim truth
 * of nakedness within. */

 public class SLList{

 	public class IntNode{
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n){
			item = i;
			next = n;
		}
	}

 	public IntNode first;

 	public SLList(int x){
 		first = new IntNode(x, null);
 	}
 	
 	public void addFirst(int x){
 		first = new IntNode(x, first);
 	}

 	public void insert(int item, int position){
 		IntNode p  = first;
 		for(int i = 0; i < position - 1; i++){
 			if(p.next == null) break;
 			p = p.next;
 		}
 		p.next = new IntNode(item, p.next);
 	}

 	public void reverse(){
 		if(first == null || first.next == null) return;
 		IntNode p = first.next;
 		first.next = null;
 		while(p != null){
 			IntNode temp = p.next;
 			p.next = first;
 			first = p;
 			p = temp;
 		}
 	}

 	public void reverseRecur(){
 		first = reverseHelp(first);
 	}

 	public IntNode reverseHelp(IntNode c){
 		if(c == null || c.next == null) return c;
 		else{
 			IntNode temp = c.next;
 			IntNode rtn = reverseHelp(c.next);
 			temp.next = c;
 			c.next = null;
 			return rtn;

 		}
 	}

 	public static void main(String[] args) {
 		SLList m = new SLList(5);
 		m.addFirst(4);
 		m.addFirst(3);
 		m.insert(0, 1);
 		m.reverseRecur();
 		System.out.println(m.first.next.next.item);
 	}
}
