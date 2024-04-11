package calculator;

public class Graph {
    private final Axis yAxis = new YAxis();
    private final Axis xAxis = new XAxis();;

    public String draw(Shape shape) {
        StringBuilder sb = new StringBuilder();
        drawPlate(sb);
        shape.draw(sb);
        return sb.toString();
    }

    private void drawPlate(StringBuilder sb) {
        yAxis.draw(sb);
        xAxis.draw(sb);
    }

}
