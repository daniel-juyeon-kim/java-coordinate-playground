package coordinate.controller;

import coordinate.model.Figure;
import coordinate.model.FigureFactory;
import coordinate.model.Point;
import coordinate.view.InputView;
import coordinate.view.ResultView;

import java.util.List;

public class CoordinateController {
    public static void run () {
        List<Point> points =  InputView.input();
        try {
            Figure figure = FigureFactory.create(points);
            ResultView.show(figure);
        } catch (IllegalArgumentException e) {
            ResultView.showError(e);
        }
    }
}
