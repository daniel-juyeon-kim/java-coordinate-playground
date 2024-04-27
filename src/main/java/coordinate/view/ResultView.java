package coordinate.view;

import coordinate.model.Figure;
import coordinate.model.Line;
import coordinate.model.Point;

import java.util.List;

public class ResultView {
    private static final int max = 24;

    public static void show(Figure figure) {
        System.out.println(draw(figure));
        showArea(figure);
    }

    private static void showArea(Figure figure) {
        if (figure instanceof Line) {
            System.out.println("두 점 사이 거리는 " + figure.area());
            return;
        }
        System.out.println(figure.getName() + " 넓이는 " + figure.area());
    }

    static String draw(Figure figure) {
        StringBuilder sb = new StringBuilder();
        drawPlate(sb);
        drawFigure(sb, figure);
        return sb.toString();
    }

    private static void drawPlate(StringBuilder sb) {
        drawY(sb);
        drawX(sb);
    }

    private static void drawFigure(StringBuilder sb, Figure figure) {
        List<Point> points = figure.getPoints();
        for (Point point : points) {
            drawPoint(sb, point);
        }
    }

    private static void drawPoint(StringBuilder sb, Point point) {
        int x = point.getX();
        int y = point.getY();

        int rowNumberSpace = 2;
        int enterSpace = 2;
        int space = 2;
        int oneLineSpace = rowNumberSpace + (space * max) + enterSpace;
        int position = rowNumberSpace + (x * space) +((max - y) * oneLineSpace);

        sb.replace(position, position + 1, "*");
    }

    private static void drawY(StringBuilder sb) {
        for (int row = max; row > 0; row--) {
            drawRow(sb, row);
        }
    }

    private static void drawRow(StringBuilder sb, int row) {
        if (isEven(row)) {
            sb.append(String.format("%2s|", row));
            drawSpace(sb);
            return;
        }
        sb.append(String.format("%2s|", "  "));
        drawSpace(sb);
    }

    private static void drawSpace(StringBuilder sb) {
        for (int col = 0; col < max; col++) {
            sb.append("  ");
        }
        sb.append("\n");
    }

    private static boolean isEven(int row) {
        return row % 2 == 0;
    }

    private static void drawX(StringBuilder sb) {
        sb.append(String.format("%2s+", ""));
        drawXLine(sb);
        sb.append(String.format("%2s ", 0));
        for (int col = 1; col <= max; col++) {
            drawCol(sb, col);
        }
    }

    private static void drawXLine(StringBuilder sb) {
        for (int col = 0; col < max; col++) {
            sb.append("--");
        }
        sb.append("\n");
    }

    private static void drawCol(StringBuilder sb, int col) {
        if (isEven(col)) {
            sb.append(String.format("%4s", col));
        }
    }

    public static void showError(Exception e) {
        System.out.println(e.getMessage());
    }
}
