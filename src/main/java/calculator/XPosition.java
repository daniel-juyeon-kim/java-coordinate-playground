package calculator;

public class XPosition extends Position{

    public XPosition(String split) {
        super(split);
    }

    @Override
    public int calculatePositionOfPlate() {
        int numberSpace = 2;
        return numberSpace + (value * 2);
    }

}
