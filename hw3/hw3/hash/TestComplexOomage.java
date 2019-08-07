package hw3.hash;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestComplexOomage {

    @Test
    public void testHashCodeDeterministic() {
        ComplexOomage so = ComplexOomage.randomComplexOomage();
        int hashCode = so.hashCode();
        for (int i = 0; i < 100; i += 1) {
            assertEquals(hashCode, so.hashCode());
        }
    }

    /* This should pass if your OomageTestUtility.haveNiceHashCodeSpread
       is correct. This is true even though our given ComplexOomage class
       has a flawed hashCode. */
    @Test
    public void testRandomOomagesHashCodeSpread() {
        List<Oomage> oomages = new ArrayList<>();
        int N = 10000;

        for (int i = 0; i < N; i += 1) {
            oomages.add(ComplexOomage.randomComplexOomage());
        }

        assertTrue(OomageTestUtility.haveNiceHashCodeSpread(oomages, 10));
    }

    /* TODO: Create a list of Complex Oomages called deadlyList
     * that shows the flaw in the hashCode function.
     */
    @Test
    public void testWithDeadlyParams() {
        List<Oomage> deadlyList = new ArrayList<>();

        ArrayList<Integer> params = new ArrayList<>(Arrays.asList(1,2,3,150,240,28,29));
        deadlyList.add(new ComplexOomage(params));
        ArrayList<Integer> params1 = new ArrayList<>(Arrays.asList(4,5,6,1,240,28,29));
        deadlyList.add(new ComplexOomage(params1));
        ArrayList<Integer> params2 = new ArrayList<>(Arrays.asList(100,2,3,150,240,28,29));
        deadlyList.add(new ComplexOomage(params2));
        ArrayList<Integer> params3 = new ArrayList<>(Arrays.asList(1,200,3,150,240,28,29));
        deadlyList.add(new ComplexOomage(params3));
        ArrayList<Integer> params4 = new ArrayList<>(Arrays.asList(1,2,37,150,240,28,29));
        deadlyList.add(new ComplexOomage(params4));
        ArrayList<Integer> params5 = new ArrayList<>(Arrays.asList(1,2,155,150,240,28,29));
        deadlyList.add(new ComplexOomage(params5));
        ArrayList<Integer> params6 = new ArrayList<>(Arrays.asList(1,2,3,150,240,28,29));
        deadlyList.add(new ComplexOomage(params6));
        ArrayList<Integer> params7 = new ArrayList<>(Arrays.asList(1,122,3,150,240,28,29));
        deadlyList.add(new ComplexOomage(params7));
        ArrayList<Integer> params8 = new ArrayList<>(Arrays.asList(13,2,3,150,240,28,29));
        deadlyList.add(new ComplexOomage(params8));
        ArrayList<Integer> params9 = new ArrayList<>(Arrays.asList(103,2,3,15,240,28,29));
        deadlyList.add(new ComplexOomage(params9));
        assertTrue(OomageTestUtility.haveNiceHashCodeSpread(deadlyList, 10));
    }

    /** Calls tests for SimpleOomage. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestComplexOomage.class);
    }
}
