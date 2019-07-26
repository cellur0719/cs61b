import java.util.Comparator;

public class Dog implements Comparable<Dog>{
	public int weightInPounds;
	public String name;

	public Dog(String n, int w){
		name = n;
		weightInPounds = w;
	}
	public void bark(){
		System.out.println("My name is " + name + ", and my weight is " + weightInPounds + " pounds.");
		
	}


	public int compareTo(Dog o){
	    return weightInPounds - o.weightInPounds;
	}

	private static class NameCompartor implements Comparator<Dog>{
		public int compare(Dog a, Dog b){
			return a.name.compareTo(b.name);
		}
	}

	public static Comparator<Dog> getNameComparator(){
		return new NameCompartor();
	}





}