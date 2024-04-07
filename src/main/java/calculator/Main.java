package calculator;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        try {
            Line line = inputView.show();
            resultView.show(new Graph(), line);
        } catch (IllegalArgumentException e) {
            resultView.showError(e);
        }

    }
}