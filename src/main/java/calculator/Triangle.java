package calculator;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Triangle extends Shape{

    private final int POINTS_SIZE = 3;
    private final String RESULT_MESSAGE = "삼각형 넓이는 ";
    private final String INVALID_POINTS_SIZE = "점이 " + POINTS_SIZE + "개가 아닙니다.";

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
        return POINTS_SIZE == value;
    }

    @Override
    String calculateArea() {
        Point point1 = points.get(0);
        Point point2 = points.get(1);
        Point point3 = points.get(2);

        double line1 = point1.calculateDistance(point2);
        double line2 = point2.calculateDistance(point3);
        double line3 = point3.calculateDistance(point1);

        double s = (line1 + line2 + line3) / 2;

        double area = Math.sqrt(s * (s - line1) * (s - line2) * (s - line3));

        return Double.toString(area);
    }



    @Override
    String generateResultMessage() {
        return RESULT_MESSAGE + calculateArea();
    }
}
