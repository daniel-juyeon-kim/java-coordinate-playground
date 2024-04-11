package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {
    @Test
    void lineConstructorTest() {
        assertDoesNotThrow(() -> {
            new Line("(10,10)-(14,15)");
        });

        assertThatThrownBy(() -> {
            new Line("(10,10)(14,15)");
        }).isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("표현식에 맞지 않습니다.");

        assertThatThrownBy(() -> {
            new Line("(10,10)-(14,15)-(1,1)");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("점이 2개가 아닙니다.");

        assertThatThrownBy(() -> {
            new Line("(10,10)-(10,10)");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복좌표가 있습니다.");
    }

    @Test
    void calculateAreaTest() {
        String actual = new Line("(0,0)-(1,1)").calculateArea();
        assertEquals(Double.parseDouble(actual), 1.41421356, 0.0000001);
    }
}
