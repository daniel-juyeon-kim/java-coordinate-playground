package calculator;

import java.util.Objects;

public abstract class Position {
    private final int MIN = 0;
    protected final int MAX = 24;
    protected final int value;
    private final String ILLEGAL_RANGE_MESSAGE = "값은 " + MIN + " 부터 " + MAX + " 사이여야 합니다.";
    private final String NOT_NUMBER_MESSAGE = "숫자만 입력 가능합니다.";

    public Position(String value) throws IllegalArgumentException{
        validate(value);
        this.value = parseToInt(value);
    }

    abstract public int calculatePositionOfPlate ();

    public int calculateDistance(Position end) {
        return this.value - end.value;
    }

    private void validate(String value) {
        checkNumber(value);
        checkRange(parseToInt(value));
    }

    private void checkNumber(String value) {
        if (isNumber(value)) {
            return;
        }
        throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
    }

    private boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void checkRange(int value) {
        if (isValidRange(value)) {
            return;
        }
        throw new IllegalArgumentException(ILLEGAL_RANGE_MESSAGE);
    }

    private boolean isValidRange(int value) {
        return MIN <= value && value <= MAX;
    }

    private int parseToInt(String value) {
        return Integer.parseInt(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
