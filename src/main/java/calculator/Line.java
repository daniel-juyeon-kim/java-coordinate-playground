package calculator;

public class Line {
    private final Point start;
    private final Point end;
    private final String splitter = "-";
    private final String InvalidFormatMessage = "표현식에 맞지 않습니다.";

    public Line(String values) throws IllegalArgumentException {
        start = new Point(split(values)[0]);
        end = new Point(split(values)[1]);
    }

    private String[] split(String values) {
        String [] splitValues = values.split(splitter);
        if (isLengthTwo(splitValues)) {
            throw new IllegalArgumentException(InvalidFormatMessage);
        }
        return splitValues;
    }

    private boolean isLengthTwo(String[] splitValues) {
        return splitValues.length != 2;
    }

    public void draw(StringBuilder sb) {
        start.draw(sb);
        end.draw(sb);
    }

    public double calculateArea() {
        return start.calculateDistance(end);
    }
}
