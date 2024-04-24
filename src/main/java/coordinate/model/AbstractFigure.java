package coordinate.model;

import java.util.*;
import java.util.function.Function;

public abstract class AbstractFigure implements Figure{

    private static final String ERROR_DUPLICATE_POINT = "중복 좌표가 존재합니다.";
    private static final int POINTS_SIZE_OF_LINE = 2;
    private static final int POINTS_SIZE_OF_TRIANGLE = 3;
    private static final int POINTS_SIZE_OF_RECTANGLE = 4;
    private static final Map<Integer, Function<List<Point>,Figure>> classifier = new HashMap<>();

    static {
        classifier.put(POINTS_SIZE_OF_LINE, Line::new);
        classifier.put(POINTS_SIZE_OF_TRIANGLE, Triangle::new);
        classifier.put(POINTS_SIZE_OF_RECTANGLE, Rectangle::new);
    }

    private List<Point> points;

    AbstractFigure(List<Point> points) {
        this.points = points;
    }

    public static Figure create(List<Point> points) {
        checkDuplicate(points);

        if (classifier.containsKey(points.size())) {
            return classifier.get(points.size()).apply(points);
        }

        return null;
    }

    private static void checkDuplicate(List<Point> points) {
        Set set = new HashSet(points);
        
        if (set.size() == points.size()) {
            return;
        }
        throw new IllegalArgumentException(ERROR_DUPLICATE_POINT);
    }

    public abstract double area();

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFigure that = (AbstractFigure) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
