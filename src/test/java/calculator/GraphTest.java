package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GraphTest {

    public static Stream<Arguments> provideValuesForDrawLineInGraphTest() {
        return Stream.of(
                Arguments.of("(0,0)-(24,24)",
                        "24|                                               *\n" +
                        "  |                                                \n" +
                        "22|                                                \n" +
                        "  |                                                \n" +
                        "20|                                                \n" +
                        "  |                                                \n" +
                        "18|                                                \n" +
                        "  |                                                \n" +
                        "16|                                                \n" +
                        "  |                                                \n" +
                        "14|                                                \n" +
                        "  |                                                \n" +
                        "12|                                                \n" +
                        "  |                                                \n" +
                        "10|                                                \n" +
                        "  |                                                \n" +
                        " 8|                                                \n" +
                        "  |                                                \n" +
                        " 6|                                                \n" +
                        "  |                                                \n" +
                        " 4|                                                \n" +
                        "  |                                                \n" +
                        " 2|                                                \n" +
                        "  |                                                \n" +
                        "  *------------------------------------------------\n" +
                        " 0    2   4   6   8  10  12  14  16  18  20  22  24")
        );
    }

    public static Stream<Arguments> provideValuesForDrawRectangleInGraphTest() {
        return Stream.of(
                Arguments.of("(0,0)-(0,24)-(24,0)-(24,24)",
                        "24*                                               *\n" +
                        "  |                                                \n" +
                        "22|                                                \n" +
                        "  |                                                \n" +
                        "20|                                                \n" +
                        "  |                                                \n" +
                        "18|                                                \n" +
                        "  |                                                \n" +
                        "16|                                                \n" +
                        "  |                                                \n" +
                        "14|                                                \n" +
                        "  |                                                \n" +
                        "12|                                                \n" +
                        "  |                                                \n" +
                        "10|                                                \n" +
                        "  |                                                \n" +
                        " 8|                                                \n" +
                        "  |                                                \n" +
                        " 6|                                                \n" +
                        "  |                                                \n" +
                        " 4|                                                \n" +
                        "  |                                                \n" +
                        " 2|                                                \n" +
                        "  |                                                \n" +
                        "  *-----------------------------------------------*\n" +
                        " 0    2   4   6   8  10  12  14  16  18  20  22  24")
        );
    }

    @ParameterizedTest
    @MethodSource("provideValuesForDrawLineInGraphTest")
    void drawLineTest(String source,String expect) {
        String actual = new Graph().draw(new Line(source));
        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("provideValuesForDrawRectangleInGraphTest")
    void drawRectangleTest(String source,String expect) {
        String actual = new Graph().draw(new Rectangle(source));
        assertThat(actual).isEqualTo(expect);
    }
}
