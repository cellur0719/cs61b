public class CatLauncher {
    public static void main(String[] args) {
        Cat a = new Cat("shupan", 10);
        System.out.println("name: " + a.name + " age: " + a.age);
        a.greet();
    }
}
