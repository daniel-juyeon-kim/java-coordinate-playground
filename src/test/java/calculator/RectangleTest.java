package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RectangleTest {

    @Test
    void rectangleTest() {

        assertDoesNotThrow(() -> {
            new Rectangle("(0,0)-(2,0)-(2,1)-(0,1)");
        });

        assertThatThrownBy(() -> {
            new Rectangle("(0,0)-(2,0)-(2,1)-(0,0)-(0,9)");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("점이 4개가 아닙니다.");

        assertThatThrownBy(() -> {
            new Rectangle("(0,0)-(2,0)-(2,1)-(0,0)");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복좌표가 있습니다.");

        assertThatThrownBy(() -> {
            new Rectangle("(0,0)-(2,0)-(2,1)-(0,3)");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("직사각형의 좌표가 아닙니다.");
    }

    @Test
    void calculateArea() {
        int area = new Rectangle("(0,14)-(2,0)-(2,14)-(0,0)").calculateArea();

        assertThat(area).isEqualTo(28);
    }
}
