package coordinate.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Rectangle extends AbstractFigure {
    private static final String ERROR_NOT_SQUARE = "사각형이 아닙니다.";

    protected Rectangle(List<Point> points) {
        super(points);
        checkRectanglePoint();
    }

    private void checkRectanglePoint() {
        Set<Integer> xs = new HashSet<>();
        Set<Integer> ys = new HashSet<>();

        getPoints().forEach(point -> {
            xs.add(point.getX());
            ys.add(point.getY());
        });

        checkRectangleSetSize(xs, ys);
    }

    private static void checkRectangleSetSize(Set<Integer> xs, Set<Integer> ys) {
        if (xs.size() == 2 && ys.size() == 2) {
            return;
        }
        throw new IllegalArgumentException(ERROR_NOT_SQUARE);
    }

    @Override
    public double area() {
        Point target = getPoints().get(0);

        List<Point> sameAxisPoints = getPoints().stream()
                .filter(point -> isNotEqualsAndSameAxis(point, target))
                .collect(Collectors.toList());

        Point sameAxisPoint1 = sameAxisPoints.get(0);
        Point sameAxisPoint2 = sameAxisPoints.get(1);

        return target.getDistance(sameAxisPoint1) * target.getDistance(sameAxisPoint2);
    }

    private static boolean isNotEqualsAndSameAxis(Point point, Point target) {
        return (!target.equals(point)) && target.isSameAxis(point);
    }
}
