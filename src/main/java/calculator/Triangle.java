package calculator;

import java.util.Arrays;
import java.util.List;

public class Triangle extends Shape{
    private final String RESULT_MESSAGE = "삼각형 넓이는 ";
    private final String INVALID_POINTS_SIZE = "점이 " + TRIANGLE_POINT_SIZE + "개가 아닙니다.";

    public Triangle(String values) {
        super(values);
        validate();
    }

    private void validate() {
        checkPointSize();
    }

    private void checkPointSize() {
        if (isThree(points.size())) {
            return;
        }
        throw new IllegalArgumentException(INVALID_POINTS_SIZE);
    }

    private boolean isThree (int value)  {
        return TRIANGLE_POINT_SIZE == value;
    }

    @Override
    String calculateArea() {
        List<Double> lines = createLines();

        double area = calculateOfficial(lines);

        return Double.toString(area);
    }

    private List<Double> createLines() {
        Point point1 = points.get(0);
        Point point2 = points.get(1);
        Point point3 = points.get(2);

        return Arrays.asList(
                point1.calculateDistance(point2),
                point2.calculateDistance(point3),
                point3.calculateDistance(point1)
        );
    }

    private double calculateOfficial(List<Double> lines) {
        double line1 = lines.get(0);
        double line2 = lines.get(1);
        double line3 = lines.get(2);

        double s = (line1 + line2 + line3) / 2;

        return Math.sqrt(s * (s - line1) * (s - line2) * (s - line3));
    }

    @Override
    String generateResultMessage() {
        return RESULT_MESSAGE + calculateArea();
    }
}
