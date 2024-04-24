package coordinate.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RectangleTest {

    @Test
    void name() {
        String ERROR_NOT_RECTANGLE = "사각형이 아닙니다.";

        assertDoesNotThrow(() -> {
            AbstractFigure.create(
                    Arrays.asList(
                            new Point(0,0),
                            new Point(0,24),
                            new Point(24,0),
                            new Point(24,24)
                    )
            );
        });

        assertThatThrownBy(() -> {
            AbstractFigure.create(
                    Arrays.asList(
                            new Point(0,0),
                            new Point(0,24),
                            new Point(23,0),
                            new Point(24,24)
                    )
            );
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_RECTANGLE);

    }

    @Test
    void areaTest() {
        double area = AbstractFigure.create(
                Arrays.asList(
                        new Point(0,0),
                        new Point(0,24),
                        new Point(24,0),
                        new Point(24,24)
                )
        ).area();

        assertThat(area).isEqualTo(576.0);

    }
}
