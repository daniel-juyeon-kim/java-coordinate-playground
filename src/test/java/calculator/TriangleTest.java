package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    @Test
    void triangleTestConstructorTest() {
        assertDoesNotThrow(() -> {
            new Triangle("(0,0)-(2,0)-(2,1)");
        });

        assertThatThrownBy(() -> {
            new Triangle("(0,0)-(2,0)-(2,1)-(4,0)");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("점이 3개가 아닙니다.");

        assertThatThrownBy(() -> {
            new Triangle("(0,0)-(2,0)-(0,0)");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복좌표가 있습니다.");
    }

    @Test
    void calculateAreaTest() {
        String actual = new Triangle("(0,0)-(2,0)-(2,2)").calculateArea();
        assertEquals(Double.parseDouble(actual), 2.0, 0.0000001);
    }
}
