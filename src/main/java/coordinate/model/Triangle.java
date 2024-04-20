package coordinate.model;

import java.util.List;

public class Triangle extends AbstractFigure {
    public static final int TRIANGLE_POINT_SIZE = 3;
    private final String NAME = "삼각형";

    public Triangle(List<Point> points) {
        super(points);
    }

    @Override
    public int size() {
        return TRIANGLE_POINT_SIZE;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public double area() {
        Point point1 = getPoint(0);
        Point point2 = getPoint(1);
        Point point3 = getPoint(2);

        double line1 = point1.getDistance(point2);
        double line2 = point2.getDistance(point3);
        double line3 = point3.getDistance(point1);

        double s = (line1 + line2 + line3) / 2;

        return Math.sqrt( s * (s - line1) * (s - line2) * (s - line3));
    }
}
