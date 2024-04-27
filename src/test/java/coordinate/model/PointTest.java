package coordinate.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {

    @Test
    void validate() {
        String ERROR_OVER_ARRANGE = "1 부터 24내의 숫자만 가능합니다.";

        assertDoesNotThrow(() -> {
            new Point(1,1);
            new Point(24,24);
        });

        assertThatThrownBy(() -> {
            new Point(-1, 1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_OVER_ARRANGE);

        assertThatThrownBy(() -> {
            new Point(1, 25);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_OVER_ARRANGE);

    }

    @Test
    void getDistance() {
        double distance = new Point(1,1).getDistance(new Point(2,2));

        assertEquals(distance, 1.4142135623730951, 0.000001);
    }
}
