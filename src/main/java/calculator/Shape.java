package calculator;

import java.util.LinkedList;
import java.util.List;

public abstract class Shape {

    protected static final int LINE_POINT_SIZE = 2;
    protected static final int TRIANGLE_POINT_SIZE = 3;
    protected static final int RECTANGLE_POINT_SIZE = 4;
    protected final List<Point> points;
    protected final static String SPLITTER = "-";
    protected final String HAS_DUPLICATE_POINT = "중복좌표가 있습니다.";
    private final static String INVALID_POINT_COUNTS = "점의 개수가 2, 3, 4개 중 하나여야 합니다.";

    protected Shape(String values) {
        this.points = generatePoints(values);
        checkDuplicatePoint();
    }

    private static List<Point> generatePoints(String values) {
        List<Point> points = new LinkedList<>();

        for (String value : split(values)) {
            points.add(new Point(value));
        }

        return points;
    }

    public static Shape generate(String values) {
        int pointSize = generatePoints(values).size();

        return generateShape(values, pointSize);
    }

    private static Shape generateShape(String values, int pointSize) {
        if (pointSize == LINE_POINT_SIZE) {
            return new Line(values);
        } else if (pointSize == TRIANGLE_POINT_SIZE) {
            return new Triangle(values);
        } else if (pointSize == RECTANGLE_POINT_SIZE) {
            return new Rectangle(values);
        }

        throw new IllegalArgumentException(INVALID_POINT_COUNTS);
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

    protected static String[] split(String values) {
        return values.split(SPLITTER);
    }

    public void draw(StringBuilder sb) {
        for (Point point : points) {
            point.draw(sb);
        }
    }

    abstract String calculateArea();
    abstract String generateResultMessage();

}
