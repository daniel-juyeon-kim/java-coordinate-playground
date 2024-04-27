package coordinate.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {

    @Test
    void areaTest() {
        double area = AbstractFigure.create(
                Arrays.asList(
                        new Point(1,1),
                        new Point(1,2)
                )
        ).area();

        assertThat(area).isEqualTo(1.0);
    }
}
