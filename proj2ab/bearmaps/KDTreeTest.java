package bearmaps;

import edu.princeton.cs.algs4.Stopwatch;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class KDTreeTest {
    private static Random r = new Random(500);

    private KDTree buildLectureTree() {
        Point p1 = new Point(2, 3); // constructs a Point with x = 1.1, y = 2.2
        Point p2 = new Point(4, 2);
        Point p3 = new Point(4, 2);
        Point p4 = new Point(4, 5);
        Point p5 = new Point(3, 3);
        Point p6 = new Point(1, 5);
        Point p7 = new Point(4, 4);

        KDTree nn = new KDTree(List.of(p1, p2, p3, p4, p5, p6, p7));
        return nn;

    }


    @Test
    /* Tests code by using examples from  the nearest slides. */
    public void testNearestDemoSlides() {
        KDTree kd = buildLectureTree();
        Point actual = kd.nearest(0, 7);
        Point expected = new Point(1, 5);
        assertEquals(expected, actual);
    }

    /* Return N random points. */
    private List<Point> randomPoints(int N) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            points.add(randomPoint());
        }
        return points;
    }

    private Point randomPoint() {
        double x = r.nextDouble();
        double y = r.nextDouble();
        return new Point(x, y);
    }

    private void testwithNPointsAndQQueries(int pointCount, int queryCount) {
        List<Point> points = randomPoints(pointCount);
        NaivePointSet nps = new NaivePointSet(points);
        KDTree kd = new KDTree(points);

        List<Point> queries = randomPoints(queryCount);
        for(Point p : queries) {
            Point expected = nps.nearest(p.getX(), p.getY());
            Point actual = kd.nearest(p.getX(), p.getY());
            assertEquals(expected, actual);
        }
    }

    private  void timeWithNPointsAndQQueries(int pointCount, int queryCount) {
        List<Point> points = randomPoints(pointCount);
        KDTree kd = new KDTree(points);



        List<Point> queries = randomPoints(queryCount);
        Stopwatch sw = new Stopwatch();
        for(Point p : queries) {
            Point actual = kd.nearest(p.getX(), p.getY());
        }
        System.out.println("Time elapsed for " + queryCount + "queries on " + pointCount + " points: " + sw.elapsedTime());
    }

    @Test
    public void testwith1000PointsAnd200Queries() {
       int pointCount = 1000;
       int queryCount = 200;
       testwithNPointsAndQQueries(pointCount,queryCount);
    }

    @Test
    public void testWith10000PointsAnd2000Queries() {
        int pointCount = 10000;
        int queryCount = 2000;
        testwithNPointsAndQQueries(pointCount,queryCount);
    }

    @Test
    public void timeWith10000PointsAnd2000Queries() {
        int pointCount = 10000;
        int queryCount = 2000;
        timeWithNPointsAndQQueries(pointCount,queryCount);

    }

    @Test
    public void timeWithVariousNumbersOfPoints() {
        List<Integer> pointCounts = List.of(1000, 10000, 100000);
        for (int N : pointCounts) {
            timeWithNPointsAndQQueries(N, 10000);
        }
    }

    @Test
    public void compareTimingOfNaiveVsKDTree() {
        List<Point> points = randomPoints(100000);
        NaivePointSet nps = new NaivePointSet(points);
        KDTree kd = new KDTree(points);

        List<Point> queries = randomPoints(10000);
        Stopwatch sw = new Stopwatch();
        for(Point p : queries) {
            Point expected = nps.nearest(p.getX(), p.getY());
        }
        double time = sw.elapsedTime();
        System.out.println("Naive 10000 queries on 100000 points: " +  time);

        sw = new Stopwatch();
        for(Point p : queries) {
            Point actual = kd.nearest(p.getX(), p.getY());
        }
        time = sw.elapsedTime();
        System.out.println("KDTree 10000 queries on 100000 points: " +  time);
    }
}
