public class selfTest{
	public static void main(String[] args) {
		LinkedListDeque<String> deque = new LinkedListDeque<>();
		deque.addFirst("a");
		deque.addLast("b");
		deque.addLast("c");
		deque.addLast("d");
		deque.addLast("e");
		deque.addLast("f");
		boolean empty = deque.isEmpty();
		int size = deque.size();

		System.out.println(size);
		System.out.println(empty);
		System.out.println(deque);

		deque.printDeque();
		deque.removeFirst();
		System.out.println(deque);
		deque.removeLast();
		System.out.println(deque);
		String t = deque.get(2);
		String t2 = deque.getRecursive(2);
		System.out.println(t);
		System.out.println(t);
		
		LinkedListDeque<String> deque2 = new LinkedListDeque<>();
		deque2.addFirst("pan");
		deque2.addFirst("shu");
		deque2.addFirst("yao");
		deque2.addFirst("jia");
		deque2.addFirst("you");
		deque2.addFirst("a");
		LinkedListDeque deque1 = new LinkedListDeque(deque2);
		size = deque1.size();
		System.out.println(size);
		deque1.printDeque();	
		

	}
}