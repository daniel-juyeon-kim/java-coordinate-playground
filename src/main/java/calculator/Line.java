package calculator;

import java.util.LinkedList;
import java.util.List;

public class Line {
    private final List<Point> points = new LinkedList<>();
    private final String splitter = "-";
    private final String InvalidFormatMessage = "표현식에 맞지 않습니다.";

    public Line(String values) throws IllegalArgumentException {
        validate(values);
        for (String value : split(values)) {
            points.add(new Point(value));
        }
    }

    private void validate(String values) {
        if (isTwo(split(values))) {
            return;
        }
        throw new IllegalArgumentException(InvalidFormatMessage);
    }

    private String[] split(String values) {
        return values.split(splitter);
    }

    private boolean isTwo(String[] splitValues) {
        return splitValues.length == 2;
    }

    public void draw(StringBuilder sb) {
        for (Point point : points) {
            point.draw(sb);
        }
    }

    public double calculateArea() {
        Point start = points.get(0);
        Point end = points.get(1);
        return start.calculateDistance(end);
    }
}
