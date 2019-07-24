public class selfTestArray{
	public static void main(String[] args) {
		ArrayDeque<String> deque = new ArrayDeque<>();
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

		deque.printDeque();
		deque.removeFirst();

		deque.removeLast();

		String t = deque.get(2);

		System.out.println(t);
		System.out.println(t);
		
		ArrayDeque<String> deque2 = new ArrayDeque<>();
		deque2.addFirst("p");
		deque2.addFirst("s");
		deque2.addFirst("y");
		deque2.addFirst("j");
		deque2.addFirst("y");
		deque2.addFirst("a");
		ArrayDeque deque1 = new ArrayDeque(deque2);
		size = deque1.size();
		System.out.println(size);
		deque1.printDeque();	
		

	}
}