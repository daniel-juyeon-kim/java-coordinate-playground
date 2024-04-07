package calculator;

public class XAxis implements Axis{
    private final String originFormat = "%3s";
    private final String originPoint = "+";
    private final String line = "-";
    private final String originNumberFormat = "%2s ";
    private final String numberFormat = "%4s";
    private final String enter = "\n";
    private final int length = this.max * 2;
    private final int max = 24;

    public void draw(StringBuilder sb) {
        drawLine(sb);
        drawNumbers(sb);
    }

    private void drawLine(StringBuilder sb) {
        drawOriginPoint(sb);
        for (int x = 0; x < length; x++) {
            sb.append(line);
        }
        sb.append(enter);
    }

    private void drawOriginPoint(StringBuilder sb) {
        sb.append(String.format(originFormat, originPoint));
    }

    private void drawNumbers(StringBuilder sb) {
        for (int x = 0; x <= max; x++) {
            drawNumber(sb, x);
        }
    }

    private void drawNumber(StringBuilder sb, int x) {
        if (isZero(x)) {
            drawOriginNumber(sb, x);
        } else if (isEven(x)) {
            sb.append(String.format(numberFormat, x));
        }
    }

    private void drawOriginNumber(StringBuilder sb, int x) {
        sb.append(String.format(originNumberFormat, x));
    }

    private boolean isZero(int x) {
        return x == 0;
    }

    private boolean isEven(int x) {
        return x % 2 == 0;
    }
}
