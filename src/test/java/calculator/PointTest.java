package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {

    @Test
    void coordinateTest() {
        assertDoesNotThrow(() -> {
            new Point("(0,24)");
        });

        assertThatThrownBy(() -> {
            new Point("(1,df)");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다.");

        assertThatThrownBy(() -> {
            new Point("(d4,3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("표현식에 맞지 않습니다.");

        assertThatThrownBy(() -> {
            new Point("8,3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("표현식에 맞지 않습니다.");

        assertThatThrownBy(() -> {
            new Point("(12,df3)(");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("표현식에 맞지 않습니다.");

        assertThatThrownBy(() -> {
            new Point("(1f,21)-(");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("표현식에 맞지 않습니다.");
    }

    @Test
    void calculateDistanceTest() {
        Point start = new Point("(0,0)");
        Point end = new Point("(1,1)");
        assertEquals(start.calculateDistance(end), 1.41421356, 0.0000001);
    }
}
