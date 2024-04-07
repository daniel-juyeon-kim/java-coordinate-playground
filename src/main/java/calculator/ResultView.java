package calculator;

public class ResultView {
    public void show(Graph graph, Line line) {
        showGraph(graph, line);
        showCalculateResult(line.calculateArea());
    }

    private void showCalculateResult(double value) {
        System.out.println("두 점 사이 거리는 " + value);
    }

    private void showGraph(Graph graph, Line line) {
        System.out.println(graph.draw(line));
    }

    public void showError(Exception e) {
        System.out.println(e.getMessage());
    }
}
