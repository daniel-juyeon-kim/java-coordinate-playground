package coordinate.model;

import java.util.LinkedList;
import java.util.List;

public class Triangle extends AbstractFigure {
    protected Triangle(List<Point> points) {
        super(points);
    }

    @Override
    public double area() {
        Point point1 = getPoints().get(0);
        Point point3 = getPoints().get(1);
        Point point2 = getPoints().get(2);

        List<Double> lines = new LinkedList<>();

        lines.add(point1.getDistance(point2));
        lines.add(point2.getDistance(point3));
        lines.add(point3.getDistance(point1));

        return formulaOfHeron(lines);
    }

    private double formulaOfHeron(List<Double> lines) {
        double line1 = lines.get(0);
        double line2 = lines.get(1);
        double line3 = lines.get(2);

        double s = (line1 + line2 + line3) / 2;

        return Math.sqrt(s * (s - line1) * (s - line2) * (s - line3));
    }
}
