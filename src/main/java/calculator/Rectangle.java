package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rectangle {

    private final List<Point> points = new LinkedList<>();
    private final String SPLITTER = "-";
    private final String HAS_DUPLICATE_POINT = "중복좌표가 있습니다.";
    private final String INVALID_POINTS_SIZE = "점이 4개가 아닙니다.";
    private final String NOT_SQUARE_POINTS = "직사각형의 좌표가 아닙니다.";
    private final int POINTS_SIZE = 4;

    public Rectangle(String values) {
        for (String value : split(values)) {
            points.add(new Point(value));
        }
        validate();
    }

    private String[] split(String values) {
        return values.split(SPLITTER);
    }

    private void validate() {
        checkPoint();
        checkDuplicatePoint();
        checkSquarePoints();
    }

    private void checkSquarePoints() {
        for (Point point : points) {
            checkTwoSameAxis(point);
        }
    }

    private void checkTwoSameAxis(Point point) {
        if (isTwoSameAxis(point)) {
            return;
        }
        throw new IllegalArgumentException(NOT_SQUARE_POINTS);
    }

    private boolean isTwoSameAxis(Point point) {
        int count = (int) filterSamePosition(point)
                .count();

        return count == 2;
    }

    private Stream<Point> filterSamePosition(Point point) {
        return points.stream()
                .filter(otherPoint -> !point.equals(otherPoint) && point.isSameAxis(otherPoint));
    }

    private void checkDuplicatePoint() {
        List<Point> checkedPoints = new LinkedList<>();
        for (Point point : points) {
            checkContainPoint(point, checkedPoints);
            checkedPoints.add(point);
        }
    }

    private void checkContainPoint(Point point, List<Point> points) {
        if (points.contains(point)) {
            throw new IllegalArgumentException(HAS_DUPLICATE_POINT);
        }
    }

    private void checkPoint() {
        if (isFour(points.size())) {
            return;
        }
        throw new IllegalArgumentException(INVALID_POINTS_SIZE);
    }

    private boolean isFour(int size) {
        return size == POINTS_SIZE;
    }

    public int calculateArea() {
        Point startPoint = points.get(0);

        List<Integer> lines = filterSamePosition(startPoint)
                                        .map(sameAxisPoint -> {
                                            return (int) startPoint.calculateDistance(sameAxisPoint);
                                        })
                                        .collect(Collectors.toList());

        return lines.get(0) * lines.get(1);
    }

    public void draw(StringBuilder sb) {
        for (Point point : points) {
            point.draw(sb);
        }
    }
}
