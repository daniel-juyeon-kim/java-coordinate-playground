package coordinate.view;

import coordinate.model.Figure;
import coordinate.model.Point;

import java.util.HashMap;
import java.util.Map;

public class ResultView {
    public static final int PLAIN_END = 24;
    public static final int PLAIN_START = 1;
    private static final Map<Integer, String> showAreaMessages = new HashMap<>();
    private static final String NUMBER_FORMAT ="%4s";
    private static final String Y_LINE = "|";
    private static final String X_LINE = "----";
    private static final String ORIGIN = "+";
    private static final String SPACE = "    ";
    private static final String POINT = ".";

    static {
        showAreaMessages.put(2, "두 점 사이 거리는 ");
        showAreaMessages.put(3, "삼각형 넓이는 ");
        showAreaMessages.put(4, "사각형 넓이는 ");
    }

    public static void draw(Figure figure) {
        for (int y = PLAIN_END; y > 0; y--) {
            drawLine(y, figure);
        }
        drawXLine();
        drawX();
    }

    private static void drawX() {
        System.out.print(String.format(NUMBER_FORMAT, "0"));
        for (int x = PLAIN_START; x <= PLAIN_END; x++) {
            drawNumber(x);
        }
        System.out.println();
    }

    private static void drawXLine() {
        System.out.print(String.format(NUMBER_FORMAT, ""));
        System.out.print(ORIGIN);
        for (int x = PLAIN_START; x <= PLAIN_END; x++) {
            System.out.print(X_LINE);
        }
        System.out.println();
    }


    private static void drawLine(int y, Figure figure) {
        drawNumber(y);
        System.out.print(Y_LINE);
        drawPoints(y, figure);
    }

    private static void drawPoints(int y, Figure figure) {
        for (int x = PLAIN_START; x <= PLAIN_END; x++) {
            Point point = new Point(x, y);
            drawPoint(figure, point);
        }
        System.out.println();
    }

    private static void drawPoint(Figure figure, Point point) {
        if (isFigurePoint(figure, point)) {
            System.out.print(String.format(NUMBER_FORMAT, POINT));
            return;
        }
        System.out.print(SPACE);
    }

    private static void drawNumber(int number) {
        if (isEven(number)) {
            System.out.print(String.format(NUMBER_FORMAT, number));
            return;
        }
        System.out.print(String.format(NUMBER_FORMAT, ""));
    }

    private static boolean isFigurePoint(Figure figure, Point point) {
        return figure.getPoints().contains(point);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void showArea(Figure figure) {
        String message = showAreaMessages.get(figure.getPoints().size());
        System.out.print(message + figure.area());
    }
}
