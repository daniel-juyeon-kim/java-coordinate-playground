package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PositionTest {
    @Test
    void XPositionConstructorTest() {
        assertDoesNotThrow(() -> {
            new XPosition("0");
            new XPosition("24");
        });

        assertThatThrownBy(() -> {
            new XPosition("-1");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("값은 0 부터 24 사이여야 합니다.");

        assertThatThrownBy(() -> {
            new XPosition("25");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("값은 0 부터 24 사이여야 합니다.");

        assertThatThrownBy(() -> {
            new XPosition("df");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }

    @Test
    void getDistance() {
        XPosition start = new XPosition("0");
        XPosition end = new XPosition("1");

        assertThat(start.calculateDistance(end)).isEqualTo(-1);
    }

    @Test
    void equalsTest() {
        Position actual = new XPosition("1");

        assertThat(actual).isEqualTo(new XPosition("1"));
        assertThat(actual).isNotEqualTo(new YPosition("1"));
        assertThat(actual).isNotEqualTo(new XPosition("0"));
    }
}
