package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Rectangle extends Shape{

    private final int POINTS_SIZE = 4;
    private final String NOT_SQUARE_POINTS = "직사각형의 좌표가 아닙니다.";
    private final String INVALID_POINTS_SIZE = "점이 " + POINTS_SIZE + "개가 아닙니다.";

    public Rectangle(String values) {
        super(values);
        validate();
    }

    private void validate() {
        checkPointSize();
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

    private void checkPointSize() {
        if (isFour(points.size())) {
            return;
        }
        throw new IllegalArgumentException(INVALID_POINTS_SIZE);
    }

    private boolean isFour(int size) {
        return size == POINTS_SIZE;
    }

    public String calculateArea() {
        Point startPoint = points.get(0);

        List<Integer> lines = filterSamePosition(startPoint)
                                        .map(sameAxisPoint -> {
                                            return (int) startPoint.calculateDistance(sameAxisPoint);
                                        })
                                        .collect(Collectors.toList());

        return Integer.toString (lines.get(0) * lines.get(1));
    }

}
