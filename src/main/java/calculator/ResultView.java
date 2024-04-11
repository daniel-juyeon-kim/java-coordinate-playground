package calculator;

public class ResultView {
    public void show(Graph graph, Shape shape) {
        showGraph(graph, shape);
        showCalculateResult(shape.generateResultMessage());
    }

    private void showCalculateResult(String value) {
        System.out.println(value);
    }

    private void showGraph(Graph graph, Shape shape) {
        System.out.println(graph.draw(shape));
    }

    public void showError(Exception e) {
        System.out.println(e.getMessage());
    }
}
