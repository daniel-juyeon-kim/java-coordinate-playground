package coordinate.model;

import java.util.List;

public class Line extends AbstractFigure{

    protected Line(List<Point> points) {
        super(points);
    }

    @Override
    public double area() {
        Point start = getPoints().get(0);
        Point end = getPoints().get(1);

        return start.getDistance(end);
    }
}
