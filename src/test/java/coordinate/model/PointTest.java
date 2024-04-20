package coordinate.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {
    @Test
    void validateTest() {
        assertDoesNotThrow(() -> {
            Point.ofCommaSeparator("0,24");
        });

        assertThatThrownBy(() -> {
            Point.ofCommaSeparator("-1,1");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Point.ofCommaSeparator("1,25");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getDistanceTest() {
        assertEquals(Point.of(1,1).getDistance(Point.of(0,0)), 1.41421356, 0.00001);
    }

    @Test
    void isSameX() {
        assertThat(Point.of(1,1).isSameX(Point.of(1,0))).isTrue();
        assertThat(Point.of(1,1).isSameX(Point.of(0,0))).isFalse();
    }

    @Test
    void isSameY() {
        assertThat(Point.of(1,1).isSameY(Point.of(0,1))).isTrue();
        assertThat(Point.of(1,1).isSameY(Point.of(0,0))).isFalse();
    }
}
