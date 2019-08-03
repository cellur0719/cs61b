package es.datastructur.synthesizer;

public class Drum {
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = 1; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public Drum(double frequency) {
        int capacity = (int) Math.round(SR/frequency);
        buffer = new ArrayRingBuffer<>(capacity);
        for (int i = 0; i < this.buffer.capacity(); i++) {
            this.buffer.enqueue(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        for(int i = 0; i < buffer.capacity(); i++){
            buffer.dequeue();
            double r = Math.random() - 0.5;
            buffer.enqueue(r);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double f = buffer.dequeue();
        double s = buffer.peek();
        double prob = Math.random();
        int flag;
        if (prob < 0.5) {
            flag = 1;
        } else {
            flag = -1;
        }
        double newSample = DECAY * 0.5 * flag * (f + s);
        buffer.enqueue(newSample);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        if (buffer.isEmpty()) {
           return 0;
        }
        double rtn = buffer.peek();
        return rtn;
    }
}
