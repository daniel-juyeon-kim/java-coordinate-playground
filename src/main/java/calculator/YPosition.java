package calculator;

public class YPosition extends Position{
    public YPosition(String value) throws IllegalArgumentException {
        super(value);
    }

    @Override
    public int calculatePositionOfPlate() {
        int lineSpace = max * 2;
        int numberSpace = 2;
        int enterSpace = 1;
        int originPointSpace = 1;
        return (numberSpace + originPointSpace + lineSpace + enterSpace ) * (max - value);
    }
}
