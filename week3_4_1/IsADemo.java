public class IsADemo {
    public static void main(String[] args) {
        AList<String> someList = new AList<>();
        someList.addFirst("elk");
        someList.addLast("dwell");
        someList.addLast("on");
        someList.addLast("existential");
        someList.addLast("crises");
        someList.print();

        SLList<String> SP = new SLList<String>();
        List61B<String> LP = SP;
        SP.addLast("elk");
        SP.addLast("are");
        SP.addLast("cool");
        List61B.peek(SP);
        List61B.peek(LP);
    }
}
