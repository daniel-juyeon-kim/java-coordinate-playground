package coordinate.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RectangleTest {
    @Test
    void areaTest() {
        Rectangle rect = new Rectangle(Arrays.asList(Point.of(1,1), Point.of(4,4), Point.of(1,4), Point.of(4,1)));

        assertThat(rect.area()).isEqualTo(9);
    }
}
