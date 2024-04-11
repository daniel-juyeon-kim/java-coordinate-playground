package calculator;

public class YAxis implements Axis{

    private final String NUMBER_FORMAT = "%3s";
    private final String LINE = "|";
    private final String ENTER = "\n";
    private final char SPACE = ' ';

    private final int MAX = 24;

    public void draw(StringBuilder sb) {
        for (int y = MAX; y > 0; y--) {
            drawNumber(sb, y);
            fillSpace(sb);
            enterLine(sb);
        }
    }

    private void enterLine(StringBuilder sb) {
        sb.append(ENTER);
    }

    private void fillSpace(StringBuilder sb) {
        for (int i = 0; i < MAX * 2; i++) {
            sb.append(SPACE);
        }
    }

    private void drawNumber(StringBuilder sb, int y) {
        if (isEven(y)) {
            sb.append(String.format(NUMBER_FORMAT, y + LINE));
            return;
        }
        sb.append(String.format(NUMBER_FORMAT, LINE));
    }

    private boolean isEven(int y) {
        return y % 2 == 0;
    }
}
