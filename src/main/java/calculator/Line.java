package calculator;

import java.util.LinkedList;
import java.util.List;

public class Line {
    private final List<Point> points = new LinkedList<>();
    private final String SPLITTER = "-";
    private final String HAS_DUPLICATE_POINT = "중복좌표가 있습니다.";
    private final String INVALID_POINTS_SIZE = "점이 2개가 아닙니다.";
    private final int POINTS_SIZE = 2;
    public Line(String values) throws IllegalArgumentException {
        for (String value : split(values)) {
            points.add(new Point(value));
        }
        validate();
    }

    private void validate() {
        checkPointsSize();
        checkDuplicatePoint();
    }

    private void checkPointsSize() {
        if (isTwo(points.size())) {
            return;
        }
        throw new IllegalArgumentException(INVALID_POINTS_SIZE);
    }

    private String[] split(String values) {
        return values.split(SPLITTER);
    }

    private boolean isTwo(int size) {
        return size == POINTS_SIZE;
    }

    public void draw(StringBuilder sb) {
        for (Point point : points) {
            point.draw(sb);
        }
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

    public double calculateArea() {
        Point start = points.get(0);
        Point end = points.get(1);
        return start.calculateDistance(end);
    }
}
