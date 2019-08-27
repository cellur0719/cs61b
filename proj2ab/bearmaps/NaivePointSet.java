package bearmaps;
import java.util.Iterator;
import java.util.List;

public class NaivePointSet implements PointSet {
    List<Point> Points;

    public NaivePointSet(List<Point> points) {
        Points = points;
    }

    public Point nearest(double x, double y) {
        Point goal = new Point(x, y);
        Iterator<Point> pointIterator = Points.iterator();
        double bestDis = 99999;
        double thisDistance;
        Point  bestPoint = pointIterator.next();
        while (pointIterator.hasNext()) {
            Point thisPoint = pointIterator.next();
            thisDistance = Point.distance(thisPoint, goal);
            if (thisDistance < bestDis) {
                bestDis = thisDistance;
                bestPoint = thisPoint;
            }
        }
        return bestPoint;
    }
}
