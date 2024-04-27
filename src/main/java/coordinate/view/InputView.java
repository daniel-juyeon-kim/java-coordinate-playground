package coordinate.view;

import coordinate.model.AbstractFigure;
import coordinate.model.Figure;
import coordinate.model.Point;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final String ERROR_INVALID_FORMAT = "형식에 맞지 않습니다.";
    private static final String ERROR_NOT_INTEGER = "정수가 아닙니다.";
    private static final String INPUT_COORDINATE = "좌표를 입력하세요.";
    private static final Scanner in = new Scanner(System.in);

    public static Figure show() {
        try {
            System.out.println(INPUT_COORDINATE);
            return createFigure(in.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return show();
        }
    }

    private static Figure createFigure(String input) {
        List<Point> points = createPoints(input);
        return AbstractFigure.create(points);
    }

    private static List<Point> createPoints(String input) {
        String[] splitInput = input.split("-");
        List<Point> points = new LinkedList<>();

        for (String inputPart : splitInput) {
            Point point = createPoint(inputPart);
            points.add(point);
        }

        return points;
    }

    private static Point createPoint(String input) {
        Pattern pattern = Pattern.compile("\\(([a-zA-Z0-9]+),([a-zA-Z0-9]+)\\)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            int x = checkInt(matcher.group(1));
            int y = checkInt(matcher.group(2));

            return new Point(x, y);
        }
        throw new IllegalArgumentException(ERROR_INVALID_FORMAT);
    }

    private static int checkInt(String stringInt) {
        try {
            return Integer.parseInt(stringInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }
}
