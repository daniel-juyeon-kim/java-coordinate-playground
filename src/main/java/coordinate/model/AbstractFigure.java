package coordinate.model;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractFigure implements Figure {
    public static final String ERROR_FIGURE_NULL = "값이 비어있습니다.";
    private final String ERROR_DUPLICATE_MESSAGE = "중복된 좌표가 있습니다.";
    private final List<Point> points;

    public AbstractFigure(List<Point> points) {
        validate(points);
        this.points = points;
    }

    private void validate(List<Point> points) {
        checkPointSize(points);
        checkDuplicatePoints(points);
    }

    private void checkDuplicatePoints(List<Point> points) {
        List<Point> validatedPoints = new LinkedList<>();

        for (Point point : points) {
            checkDuplicatePoint(validatedPoints, point);
            validatedPoints.add(point);
        }
    }

    private void checkPointSize(List<Point> points) {
        if (points.size() != size()) {
            throw new IllegalArgumentException(getName() + "의 길이는 " + size() + "이어야 합니다.");
        }
    }

    private void checkDuplicatePoint(List<Point> validatedPoints, Point point) {
        if (validatedPoints.contains(point)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_MESSAGE);
        }
    }

    protected Point getPoint(int index) {
        return points.get(index);
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }
}
