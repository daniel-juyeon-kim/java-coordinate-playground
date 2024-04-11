package calculator;

public class Graph {
    private final Axis yAxis = new YAxis();
    private final Axis xAxis = new XAxis();;

    public String draw(Line line) {
        StringBuilder sb = new StringBuilder();
        drawPlate(sb);
        line.draw(sb);
        return sb.toString();
    }

    public String draw(Rectangle rectangle) {
        StringBuilder sb = new StringBuilder();
        drawPlate(sb);
        rectangle.draw(sb);
        return sb.toString();
    }

    private void drawPlate(StringBuilder sb) {
        yAxis.draw(sb);
        xAxis.draw(sb);
    }

}
