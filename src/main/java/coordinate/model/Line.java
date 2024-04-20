package coordinate.model;

import java.util.List;

public class Line extends AbstractFigure {
    public static final int LINE_POINT_SIZE = 2;
    private final String NAME = "선";

    public Line(List<Point> points) {
        super(points);
    }

    @Override
    public int size() {
        return LINE_POINT_SIZE;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public double area() {
        Point start = getPoint(0);
        Point end = getPoint(1);

        return start.getDistance(end);
    }
}
