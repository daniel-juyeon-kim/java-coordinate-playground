package coordinate.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {
    @Test
    void areaTest() {
        double area = new Line(Arrays.asList(Point.of(1,1), Point.of(4,4))).area();
        assertEquals(area, 4.242640687119285, 0.0000001);
    }
}
