public class WordUtils{
	public static String longest(List61B<String> list){
		int maxIndex = 0;
		for(int i = 0; i < list.size(); i++){
			String now = list.get(i);
			String max = list.get(maxIndex);
			if (now.length() > max.length()) {
				maxIndex = i;
			}
		}
		return list.get(maxIndex);
	}


	public static void main(String[] args) {
		AList<String> someList = new AList<>();
		someList.addFirst("elk");
		someList.addFirst("are");
		someList.addFirst("watching");
		someList.addFirst("shjadbfkajnsdkjb");
		System.out.println(longest(someList));
	}
}