public class DMSList{
	private IntNode sentinel;
	public DMSList(){
		sentinel = new IntNode(-1000, new LastIntNode());
	}

	public class IntNode{
		public int item;
		public IntNode next;
		public IntNode(int i, IntNode h){
			item = i;
			next = h;
		}

		public int max(){
			return Math.max(item, next.max());
		}
	}

	public int max(){
		return sentinel.next.max();
	}

	public class LastIntNode extends IntNode{
		public LastIntNode(){
			super(0, null);
		}
		@Override
		public int max(){
			return 0;
		}
	}

	public static void main(String[] args) {
		DMSList d = new DMSList();
		d.sentinel.next = new DMSList().new IntNode(5, d.sentinel.next);
		d.sentinel.next = new DMSList().new IntNode(3, d.sentinel.next);
		d.sentinel.next = new DMSList().new IntNode(1, d.sentinel.next);
		System.out.println(d.max());
	}
}