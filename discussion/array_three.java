public class discussion{
	public static int[] insert(int[] arr, int item, int position){
		int size = arr.length;
		int rtn[] = new int[size + 1];
		if(position >= size) rtn[size] = item;
		else{
			System.arraycopy(arr, 0, rtn, 0, position);
			rtn[position] = item;
			System.arraycopy(arr, position, rtn, position + 1, size - position);
		}
		return rtn;
	}

	public static void reverse(int[] arr){
		int size = arr.length;
		for(int i = 0; i < size/2; i++){
			int temp = arr[i];
			arr[i] = arr[size - 1 - i];
			arr[size - 1 - i] = temp;
		}
	}

	public static int[] replicate(int[] arr){
		int size = arr.length;
		int size2 = 0;
		for(int i = 0; i < size; i++){
			size2 += arr[i];
		}
		int[] rtn = new int[size2];
		int flag = 0;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < arr[i]; j++){
				rtn[flag++] = arr[i];
			}
		}
		return rtn;
	}

	public static void main(String[] args) {
		int[] z = {3, 2, 1};
		//int[] result = insert(z, 6, 10);
		int[] rtn = replicate(z);
		System.out.println(rtn[0]);
		System.out.println(rtn[1]);
		System.out.println(rtn[2]);
		System.out.println(rtn[3]);
		System.out.println(rtn[4]);
		System.out.println(rtn[5]);
	}
}