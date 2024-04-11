package calculator;

public class ResultView {
    private final String RESULT_MESSAGE = "두 점 사이 거리는 ";
    public void show(Graph graph, Shape shape) {
        showGraph(graph, shape);
        showCalculateResult(shape.calculateArea());
    }

    private void showCalculateResult(String value) {
        System.out.println(RESULT_MESSAGE + value);
    }

    private void showGraph(Graph graph, Shape shape) {
        System.out.println(graph.draw(shape));
    }

    public void showError(Exception e) {
        System.out.println(e.getMessage());
    }
}
