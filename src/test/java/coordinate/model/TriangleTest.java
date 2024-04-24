package coordinate.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    @Test
    void areaTest() {
        double area = AbstractFigure.create(Arrays.asList(
                new Point(0,0),
                new Point(24,0),
                new Point(0,24)
        )).area();

        assertEquals(area, 288.0, 0.1);
    }
}
