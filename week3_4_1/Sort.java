public class Sort{
	public static void sort(String[] x){
		// find the smallest item
        // move it to the front
        // selection sort the rest (using recursion?)

		sort(x, 0);
		
	}

	private static void sort(String[] x, int start){
		if(start == x.length) return;
		int smallest = findSmallest(x, start);
		Swap(x, smallest, start);
		sort(x, start + 1);
	}


	public static int findSmallest(String[] x, int start){
		int smallestIndex = start;
		for (int i = start; i < x.length; i += 1) {
			int cmp = x[i].compareTo(x[smallestIndex]);
			if (cmp < 0) {
				smallestIndex = i;
			}
		}
		return smallestIndex;
	}

	public static void Swap(String[] x, int a, int b){
		String temp = x[a];
		x[a] = x[b];
		x[b] = temp;
	}
}
