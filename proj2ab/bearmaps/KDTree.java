package bearmaps;
import java.util.*;

public class KDTree implements PointSet{
    private Node root;
    private class Node {
        private Point p;
        private boolean orientation = true; //true means LR; false means UD;
        private Node leftChild;
        private Node rightChild;

        private Node(Point p) {
            this.p = p;
        }

        private double compareTo(Node o) {
            if (o.orientation) {
                return this.p.getX() - o.p.getX();
            } else {
                return this.p.getY() - o.p.getY();
            }
        }

        private boolean equal(Node o) {
            if (p.getX() == o.p.getX() && p.getY() == o.p.getY()) {
                return true;
            }
            return false;
        }
    }

    public static class posComparatorLR implements Comparator<Point> {
        @Override
        public int compare(Point o, Point goal) {
            if (goal.getX() < o.getX()) {
                return -1;
            } return 1;
        }
    }

    public static class posComparatorUD implements Comparator<Point> {
        @Override
        public int compare(Point o, Point goal) {
            if (goal.getY() < o.getY()) {
                return -1;
            } return 1;
        }
    }

    private void add(Point e) {
        Node newNode = new Node(e);
        if (root == null) {
            root = newNode;
            return;
        }
        Node compareNode = root;
        while(compareNode != null) {
            if (newNode.equal(compareNode)) {
                return;
            }
            if (newNode.compareTo(compareNode) < 0) {
                if (compareNode.leftChild == null) {
                    compareNode.leftChild = newNode;
                    compareNode.leftChild.orientation = !compareNode.orientation;
                    return;
                }
                compareNode = compareNode.leftChild;
            } else {
                if (compareNode.rightChild == null) {
                   compareNode.rightChild = newNode;
                   compareNode.rightChild.orientation = !compareNode.orientation;
                   return;
                }
                compareNode = compareNode.rightChild;
            }
        }
    }

    public KDTree(List<Point> points) {

        Iterator<Point> pointIterator = points.iterator();
        while (pointIterator.hasNext()) {
            Point in = pointIterator.next();
            this.add(in);
        }
    }

    @Override
    public Point nearest(double x, double y){
        Point goal = new Point(x, y);
        Node rtn = nearest(root, goal, root);
        return rtn.p;
    }

    public Node nearest(Node n, Point goal, Node best) {
        Comparator<Point> comp;
        Node goodSide;
        Node badSide;
        if (n == null) {
            return best;
        }
        if (Point.distance(n.p, goal) < Point.distance(best.p, goal)) {
            best = n;
        }
        if (n.orientation) {
            comp = new KDTree.posComparatorLR();
        } else {
            comp = new KDTree.posComparatorUD();
        }
        if (comp.compare(n.p, goal) < 0) {
            goodSide = n.leftChild;
            badSide = n.rightChild;
        } else {
            goodSide = n.rightChild;
            badSide =  n.leftChild;
        }
        best = nearest(goodSide, goal, best);


        if (n.orientation) {
            if (Math.abs(Math.pow((n.p.getX() - goal.getX()), 2) - Point.distance(best.p, goal)) < 1) {
                best = nearest(badSide, goal, best);
            }
        } else {
            if (Math.abs(Math.pow((n.p.getY() - goal.getY()), 2) - Point.distance(best.p, goal)) < 1) {
                best = nearest(badSide, goal, best);
            }
        }
        //best = nearest(badSide, goal, best);
        return best;
    }

    public static void main(String[] args) {
        Point p1 = new Point(2, 3); // constructs a Point with x = 1.1, y = 2.2
        Point p2 = new Point(4, 2);
        Point p3 = new Point(4, 2);
        Point p4 = new Point(4, 5);
        Point p5 = new Point(3, 3);
        Point p6 = new Point(1, 5);
        Point p7 = new Point(4, 4);

        KDTree nn = new KDTree(List.of(p1, p2, p3, p4, p5, p6, p7));
        Point ret = nn.nearest(3.0, 4.0); // returns p2
        System.out.println(ret.getX()); // evaluates to 3.3
        System.out.println(ret.getY()); // evaluates to 4.4

    }
}
