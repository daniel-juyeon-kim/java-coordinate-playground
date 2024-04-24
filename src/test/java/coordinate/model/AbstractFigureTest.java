package coordinate.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AbstractFigureTest {

    public static Stream<Arguments> provideParameterForCreateTest() {
        return Stream.of(
                Arguments.of(
                        AbstractFigure.create(
                                Arrays.asList(
                                        new Point(0,0)
                                )
                        ), null),
                Arguments.of(
                        AbstractFigure.create(
                                Arrays.asList(
                                        new Point(0,0),
                                        new Point(0,1)
                                )
                        ),
                        AbstractFigure.create(
                                Arrays.asList(
                                        new Point(0,0),
                                        new Point(0,1)
                                )
                        )),
                Arguments.of(
                        AbstractFigure.create(
                                Arrays.asList(
                                        new Point(0,0),
                                        new Point(0,24),
                                        new Point(24,0),
                                        new Point(24,24)
                                )
                        ),
                        AbstractFigure.create(
                                Arrays.asList(
                                        new Point(0,0),
                                        new Point(0,24),
                                        new Point(24,0),
                                        new Point(24,24)
                                )
                        )),
                Arguments.of(
                        AbstractFigure.create(
                                Arrays.asList(
                                        new Point(0,0),
                                        new Point(2,24),
                                        new Point(4,0),
                                        new Point(5,24),
                                        new Point(24,0)
                                )
                        ), null)
        );
    }

    @Test
    void checkDuplicate() {
        String ERROR_DUPLICATE_POINT = "중복 좌표가 존재합니다.";

        assertDoesNotThrow(() -> {
            AbstractFigure.create(Arrays.asList(new Point(1,1), new Point(1,0)));
        });

        assertThatThrownBy(() -> {
            AbstractFigure.create(Arrays.asList(
                    new Point(1,1),
                    new Point(1,0),
                    new Point(1,1)
            ));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_DUPLICATE_POINT);
    }

    @ParameterizedTest
    @MethodSource("provideParameterForCreateTest")
    void create(Figure actual, Figure expect) {
        assertThat(actual).isEqualTo(expect);
    }
}
