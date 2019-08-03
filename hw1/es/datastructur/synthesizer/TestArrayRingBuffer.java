package es.datastructur.synthesizer;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(3);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        assertEquals(3, arb.fillCount());
        assertEquals(3, arb.capacity());
        assertTrue(arb.isFull());
        int actual = arb.dequeue();
        assertEquals(1, actual);
        assertEquals(2,arb.fillCount());
        arb.enqueue(4);
        for(int i : arb){
            System.out.println(i);
        }
        ArrayRingBuffer<Integer>  arb2 = new ArrayRingBuffer<>(5);
        arb2.enqueue(2);
        arb2.enqueue(3);
        arb2.enqueue(4);
        assertTrue(arb.equals(arb2));
    }
}
