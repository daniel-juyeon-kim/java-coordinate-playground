package calculator;

public class Line extends Shape{

    private final String RESULT_MESSAGE = "두 점 사이 거리는 ";
    private final String INVALID_POINTS_SIZE = "점이 " + LINE_POINT_SIZE + "개가 아닙니다.";
    public Line(String values) throws IllegalArgumentException {
        super(values);
        validate();
    }

    private void validate() {
        checkPointsSize();
    }

    private void checkPointsSize() {
        if (isTwo(points.size())) {
            return;
        }
        throw new IllegalArgumentException(INVALID_POINTS_SIZE);
    }

    private boolean isTwo(int size) {
        return size == LINE_POINT_SIZE;
    }

    @Override
    public String calculateArea() {
        Point start = points.get(0);
        Point end = points.get(1);
        return Double.toString(start.calculateDistance(end));
    }

    @Override
    public String generateResultMessage() {
        return RESULT_MESSAGE + calculateArea();
    }
}
