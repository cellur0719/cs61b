package bearmaps;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayHeapMinPQTest {

    @Test
    public void testAdd() {
        ArrayHeapMinPQ<Character> pq = new ArrayHeapMinPQ();
        pq.add('g', 4);
        pq.add('j', 10);
        pq.add('y', 6);
        pq.add('k', 0);
        pq.add('b', 3);
        pq.add('m', 11);
        pq.add('v', 2);
        pq.add('a', 7);
        pq.add('e', 1);
        pq.add('p', 5);
        pq.add('d', 8);
        pq.add('f', 9);
        pq.add('x', 13);
        pq.add('r', 12);
        pq.removeSmallest();
        assertTrue('e' == pq.getSmallest());
        pq.removeSmallest();
        assertTrue('v' == pq.getSmallest());
    }

    @Test
    public void testContains(){
        ArrayHeapMinPQ<Character> pq = new ArrayHeapMinPQ();
        pq.add('g', 4);
        pq.add('j', 10);
        pq.add('y', 6);
        pq.add('b', 3);
        pq.add('m', 11);
        pq.add('v', 2);
        pq.add('a', 7);
        pq.add('e', 1);
        pq.add('p', 5);
        pq.add('d', 8);
        pq.add('f', 9);
        pq.add('x', 13);
        pq.add('r', 12);
        pq.changePriority('r', 0.01);
        assertTrue('r' == pq.getSmallest());
    }


}
