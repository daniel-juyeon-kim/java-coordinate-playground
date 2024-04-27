package coordinate.controller;

import coordinate.model.Figure;
import coordinate.view.InputView;
import coordinate.view.ResultView;

public class CoordinateController {
    public static void run () {
        Figure figure = InputView.show();
        ResultView.draw(figure);
        ResultView.showArea(figure);
    }
}
