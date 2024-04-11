package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Point {
    private final String notMatchMessage = "표현식에 맞지 않습니다.";
    private final String pointChar = "*";
    private final Position x;
    private final Position y;

    public Point(String expression) {
        validate(expression);

        this.x = new XPosition(split(expression, 1));
        this.y = new YPosition(split(expression, 2));
    }

    private void validate(String expression) {
        checkMatch(expression);
    }

    private void checkMatch(String expression) {
        if (isMatch(expression)) {
            return;
        }
        throw new IllegalArgumentException(notMatchMessage);
    }

    private boolean isMatch(String expression) {
        Matcher matcher = match(expression);

        return matcher.find();
    }

    private Matcher match(String expression) {
        Pattern pattern = Pattern.compile("^\\((-?\\w+),(-?\\w+)\\)$");
        return pattern.matcher(expression);
    }

    private String split(String expression, int index) {
        Matcher matcher = match(expression);

        if (matcher.find()) {
            return matcher.group(index);
        }
        return null;
    }

    public double calculateDistance(Point end) {
        int xDistance = this.x.calculateDistance(end.x);
        int yDistance = this.y.calculateDistance(end.y);

        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }

    public void draw(StringBuilder sb) {
        int platePosition = x.calculatePositionOfPlate() + y.calculatePositionOfPlate();
        sb.replace(platePosition, platePosition + 1, pointChar);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(x, point.x) && Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
