import static org.junit.Assert.*;

import org.junit.Test;
public class TestUnionFind {
    public static void main(String[] args) {
        UnionFind a = new UnionFind(7);
        a.union(0, 1);
        a.union(1, 2);
        a.union(0, 4);
        a.union(3, 5);
        a.union(3, 6);
        boolean judge = a.connected(4, 2);
        System.out.println(judge);
        System.out.println(a.find(0));
        System.out.println(a.find(2));
        System.out.println(a.find(1));
        System.out.println(a.find(4));
        System.out.println(a.find(5));
        System.out.println(a.sizeOf(3));
        a.union(4, 6);
        System.out.println(a.sizeOf(1));
        System.out.println(a.find(5));
        a.union(2,3);
        System.out.println(a.sizeOf(0));
    }



}
