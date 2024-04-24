package coordinate.model;

import java.util.Objects;

public class Point {
    private final String ERROR_OVER_ARRANGE = "%d 부터 %d내의 숫자만 가능합니다.";
    public final int MAXIMUM_VALUE = 24;
    public final int MINIMUM_VALUE = 0;
    private final int x;
    private final int y;

    public Point(int x, int y) {
        checkValidArrange(x);
        checkValidArrange(y);

        this.x = x;
        this.y = y;
    }

    private void checkValidArrange(int value) {
        if (isValidArrange(value)) {
            return;
        }
        throw new IllegalArgumentException(String.format(ERROR_OVER_ARRANGE, MINIMUM_VALUE, MAXIMUM_VALUE));
    }


    private boolean isValidArrange(int value) {
        return MINIMUM_VALUE <= value && value <= MAXIMUM_VALUE;
    }

    public double getDistance(Point that) {
        int xDistance = Math.abs(this.x - that.x);
        int yDistance = Math.abs(this.y - that.y);

        return Math.sqrt(getSquare(xDistance) + getSquare(yDistance));
    }

    private int getSquare (int value) {
        return value * value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSameAxis(Point that) {
        return this.x == that.x || this.y == that.y;
    }
}
