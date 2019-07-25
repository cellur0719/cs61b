public class Demo{

	public static int do_twice(IntUnaryFunction f, int x){
		return f.apply(f.apply(x));
	}

	public static void main(String[] args) {
		IntUnaryFunction f = new TenX();
		System.out.println(do_twice(f, 2));
	}
}