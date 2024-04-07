package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {
    @Test
    void CoordinatesTest() {
        assertDoesNotThrow(() -> {
            new Line("(10,10)-(14,15)");
        });

        assertThatThrownBy(() -> {
            new Line("(10,10)(14,15)");
        }).isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("표현식에 맞지 않습니다.");
    }

    @Test
    void calculateAreaTest() {
        double actual = new Line("(0,0)-(1,1)").calculateArea();
        assertEquals(actual, 1.41421356, 0.0000001);
    }
}
