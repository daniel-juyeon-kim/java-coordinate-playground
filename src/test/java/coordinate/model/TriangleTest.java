package coordinate.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    @Test
    void areaTest() {
        double area = AbstractFigure.create(Arrays.asList(
                new Point(1,1),
                new Point(24,1),
                new Point(1,24)
        )).area();

        assertEquals(area, 264.5, 0.1);
    }
}
