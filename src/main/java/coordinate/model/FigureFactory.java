package coordinate.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
    private static final String INVALID_POINT_SIZE = "입력된 Point 개수가 유효하지 않습니다.";
    private static final int POINT_SIZE_OF_LINE = 2;
    private static final int POINT_SIZE_OF_TRIANGLE = 3;
    private static final int POINT_SIZE_OF_RECTANGLE = 4;
    private static final Map<Integer, Function<List<Point>, Figure>> constructorMap = new HashMap<>();

    static {
        constructorMap.put(POINT_SIZE_OF_LINE, Line::new);
        constructorMap.put(POINT_SIZE_OF_TRIANGLE, Triangle::new);
        constructorMap.put(POINT_SIZE_OF_RECTANGLE, Rectangle::new);
    }

    public static Figure create(List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException(AbstractFigure.ERROR_FIGURE_NULL);
        }
        else if (isInvalidPointSize(points)) {
            throw new IllegalArgumentException(INVALID_POINT_SIZE);
        }
        return createFigure(points);
    }

    private static boolean isInvalidPointSize(List<Point> points) {
        return points.size() < 2 || 4 < points.size();
    }

    static Figure createFigure(List<Point> points) {
        return constructorMap.get(points.size()).apply(points);
    }

}
