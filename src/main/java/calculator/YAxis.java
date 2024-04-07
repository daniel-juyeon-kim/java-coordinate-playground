package calculator;

public class YAxis implements Axis{

    private final String numberFormat = "%3s";
    private final String line = "|";
    private final String enter = "\n";
    private final char space = ' ';

    private final int max = 24;


    public void draw(StringBuilder sb) {
        for (int y = max; y > 0; y--) {
            drawNumber(sb, y);
            fillSpace(sb);
            enterLine(sb);
        }
    }

    private void enterLine(StringBuilder sb) {
        sb.append(enter);
    }

    private void fillSpace(StringBuilder sb) {
        for (int i = 0; i < max * 2; i++) {
            sb.append(space);
        }
    }

    private void drawNumber(StringBuilder sb, int y) {
        if (isEven(y)) {
            sb.append(String.format(numberFormat, y + line));
            return;
        }
        sb.append(String.format(numberFormat, line));
    }

    private boolean isEven(int y) {
        return y % 2 == 0;
    }
}
