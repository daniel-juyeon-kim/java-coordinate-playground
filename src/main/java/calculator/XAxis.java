package calculator;

public class XAxis implements Axis{
    private final String ORIGIN_FORMAT = "%3s";
    private final String ORIGIN_POINT = "+";
    private final String LINE = "-";
    private final String ORIGIN_NUMBER_FORMAT = "%2s ";
    private final String NUMBER_FORMAT = "%4s";
    private final String ENTER = "\n";
    private final int LENGTH = this.MAX * 2;
    private final int MAX = 24;

    public void draw(StringBuilder sb) {
        drawLine(sb);
        drawNumbers(sb);
    }

    private void drawLine(StringBuilder sb) {
        drawOriginPoint(sb);
        for (int x = 0; x < LENGTH; x++) {
            sb.append(LINE);
        }
        sb.append(ENTER);
    }

    private void drawOriginPoint(StringBuilder sb) {
        sb.append(String.format(ORIGIN_FORMAT, ORIGIN_POINT));
    }

    private void drawNumbers(StringBuilder sb) {
        for (int x = 0; x <= MAX; x++) {
            drawNumber(sb, x);
        }
    }

    private void drawNumber(StringBuilder sb, int x) {
        if (isZero(x)) {
            drawOriginNumber(sb, x);
        } else if (isEven(x)) {
            sb.append(String.format(NUMBER_FORMAT, x));
        }
    }

    private void drawOriginNumber(StringBuilder sb, int x) {
        sb.append(String.format(ORIGIN_NUMBER_FORMAT, x));
    }

    private boolean isZero(int x) {
        return x == 0;
    }

    private boolean isEven(int x) {
        return x % 2 == 0;
    }
}
