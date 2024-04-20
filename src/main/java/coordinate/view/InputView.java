package coordinate.view;

import coordinate.model.Point;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static Scanner in = new Scanner(System.in);
    private static String INPUT_POINTS_MESSAGE = "좌표를 입력하세요.";
    private static String POINT_SPPLITTER = "-";
    public static List<Point> input() {
        showMessage(INPUT_POINTS_MESSAGE);
        String command = in.nextLine();

        try {
            validate(command);
            return createPoints(command);
        } catch (IllegalArgumentException e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    private static List<Point> createPoints(String command) {
        String[] splitValue = command.split(POINT_SPPLITTER);
        List<Point> points = new LinkedList<>();

        for (String value : splitValue) {
            points.add(Point.ofCommaSeparator(removeBracket(value)));
        }

        return points;
    }

    private static String removeBracket(String value) {
        return value.replace("(", "")
                .replace(")", "");
    }

    private static void showMessage(String message) {
        System.out.println(message);
    }

    private static void validate(String expression) {
        String [] splitExpressions =  expression.split(POINT_SPPLITTER);

        for (String pointExpression : splitExpressions) {
            checkLegalFormat(pointExpression);
        }
    }

    private static void checkLegalFormat(String pointExpression) {
        Pattern pattern = Pattern.compile("\\(([0-9]{1,2}),([0-9]{1,2})\\)");
        Matcher matcher = pattern.matcher(pointExpression);

        if (matcher.find()) {
           return;
        }
        throw new IllegalArgumentException("형식이 올바르지 않습니다.");
    }

//    private static boolean isLegalFormat(String pointExpression, Pattern pattern) {
//        return !pattern.matcher(pointExpression).find();
//    }

}
