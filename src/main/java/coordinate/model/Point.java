package coordinate.model;

import java.util.Objects;

public class Point {
    private final int x;
    private final int y;
    private final int MIN = 0;
    private final int MAX = 24;
    private static final String SPERATOR = ",";

    private Point(int x, int y) {
        this.x = x;
        if (x < MIN || MAX < x) {
            throw new IllegalArgumentException();
        }

        this.y = y;
        if (y < MIN || MAX < y) {
            throw new IllegalArgumentException();
        }
    }

    public double getDistance(Point other) {
        int xDifference = other.minusX(x);
        int yDifference = other.minusY(y);
        return Math.sqrt(square(xDifference) + square(yDifference));
    }

    private int minusX(int number) {
        return this.x - number;
    }

    private int minusY(int number) {
        return this.y - number;
    }

    private static int square(int number) {
        return number * number;
    }

    public static Point of(int x, int y) {
        return new Point(x, y);
    }

    public static Point ofCommaSeparator(String text) {
        String[] values = text.split(SPERATOR);
        return new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    }

    public boolean isSameX (Point other) {
        return this.x == other.x;
    }

    public boolean isSameY (Point other) {
        return this.y == other.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
