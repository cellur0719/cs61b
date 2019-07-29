import java.util.HashSet;
import java.util.Set;
public class JavaSetPrintDemo {
    public static void main(String[] args) {
        Set<Integer> javaSet = new HashSet<>();
        javaSet.add(5);
        javaSet.add(23);
        javaSet.add(42);
        Set<Integer> javaSet2 = Set.of(42, 23, 5);

        Set<Integer> javaSet3 = Set.of(42, 23, 5);
        System.out.println(javaSet3);
        System.out.println(javaSet2);
        System.out.println(javaSet3.equals(javaSet2));
    }
}
