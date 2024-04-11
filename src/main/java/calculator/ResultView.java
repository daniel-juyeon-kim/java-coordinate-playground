package calculator;

public class ResultView {
    private final String RESULT_MESSAGE = "두 점 사이 거리는 ";
    public void show(Graph graph, Line line) {
        showGraph(graph, line);
        showCalculateResult(line.calculateArea());
    }

    private void showCalculateResult(double value) {
        System.out.println(RESULT_MESSAGE + value);
    }

    private void showGraph(Graph graph, Line line) {
        System.out.println(graph.draw(line));
    }

    public void showError(Exception e) {
        System.out.println(e.getMessage());
    }
}
