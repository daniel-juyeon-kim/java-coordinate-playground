package coordinate.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    @Test
    void areaTest() {
        Triangle tri = new Triangle(Arrays.asList(Point.of(0,0), Point.of(1,1), Point.of(1,0)));

        assertEquals(tri.area(), 0.5, 0.1);
    }
}
