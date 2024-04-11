package calculator;

public class Calculator {
    public void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        try {
            Shape shape = inputView.show();
            resultView.show(new Graph(), shape);
        } catch (IllegalArgumentException e) {
            resultView.showError(e);
        }
    }
}
