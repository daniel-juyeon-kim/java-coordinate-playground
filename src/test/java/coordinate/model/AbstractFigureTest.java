package coordinate.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AbstractFigureTest {

    public static Stream<Arguments> provideParameterForCreateTest() {
        return Stream.of(
                Arguments.of(
                    Arrays.asList(
                                new Point(1,1)
                        ),
                        null
                ),
                Arguments.of(
                        Arrays.asList(
                                new Point(1,1),
                                new Point(1,2)
                        ),
                        Arrays.asList(
                                new Point(1,1),
                                new Point(1,2)
                        )
                ),
                Arguments.of(
                        Arrays.asList(
                                new Point(1,1),
                                new Point(1,24),
                                new Point(24,1),
                                new Point(24,24)
                        ),
                        Arrays.asList(
                                new Point(1,1),
                                new Point(1,24),
                                new Point(24,1),
                                new Point(24,24)
                        )
                ),
                Arguments.of(
                        Arrays.asList(
                                new Point(1,1),
                                new Point(2,24),
                                new Point(4,1),
                                new Point(5,24),
                                new Point(24,1)
                        ),
                        null
                )
        );
    }

    @Test
    void checkDuplicate() {
        String ERROR_DUPLICATE_POINT = "중복 좌표가 존재합니다.";

        assertDoesNotThrow(() -> {
            AbstractFigure.create(Arrays.asList(new Point(1,1), new Point(1,2)));
        });

        assertThatThrownBy(() -> {
            AbstractFigure.create(Arrays.asList(
                    new Point(1,1),
                    new Point(1,2),
                    new Point(1,1)
            ));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_DUPLICATE_POINT);
    }

    @ParameterizedTest
    @MethodSource("provideParameterForCreateTest")
    void create(List<Point> points, List<Point> expect) {
        if (expect == null) {
            assertThatThrownBy(() -> {
                AbstractFigure.create(points);
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("해당 모형은 지원하지 않습니다.");
            return;
        }
        assertThat(AbstractFigure.create(points)).isEqualTo(AbstractFigure.create(expect));
    }
}
