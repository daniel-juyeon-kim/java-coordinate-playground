package coordinate.model;

import java.util.List;
import java.util.stream.Collectors;

public class Rectangle extends AbstractFigure {
    public static final int RECTANGLE_POINT_SIZE = 4;
    private final String NAME = "사각형";

    public Rectangle(List<Point> points) {
        super(points);
    }

    @Override
    public int size() {
        return RECTANGLE_POINT_SIZE;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public double area() {
        Point targetPoint = getPoint(0);

        List<Point> sameAxisPoints = getPoints().stream()
                        .filter(point -> !targetPoint.equals(point) &&  isSameAxis(point, targetPoint))
                        .collect(Collectors.toList());

        return targetPoint.getDistance(sameAxisPoints.get(0)) * targetPoint.getDistance(sameAxisPoints.get(1));
    }

    private boolean isSameAxis(Point point, Point targetPoint) {
        return targetPoint.isSameX(point) || targetPoint.isSameY(point);
    }

}
