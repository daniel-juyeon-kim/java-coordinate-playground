package coordinate.view;

import coordinate.model.Line;
import coordinate.model.Point;
import coordinate.model.Rectangle;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultViewTest {

    @Test
    void name() {
        String plate = ResultView.draw(new Rectangle(Arrays.asList(
                Point.of(0,0),
                Point.of(24,0),
                Point.of(0,24),
                Point.of(24,24)
        )));

        assertThat(plate).isEqualTo(
               "24*                                               *\n"+
                        "  |                                                \n"+
                        "22|                                                \n"+
                        "  |                                                \n"+
                        "20|                                                \n"+
                        "  |                                                \n"+
                        "18|                                                \n"+
                        "  |                                                \n"+
                        "16|                                                \n"+
                        "  |                                                \n"+
                        "14|                                                \n"+
                        "  |                                                \n"+
                        "12|                                                \n"+
                        "  |                                                \n"+
                        "10|                                                \n"+
                        "  |                                                \n"+
                        " 8|                                                \n"+
                        "  |                                                \n"+
                        " 6|                                                \n"+
                        "  |                                                \n"+
                        " 4|                                                \n"+
                        "  |                                                \n"+
                        " 2|                                                \n"+
                        "  |                                                \n"+
                        "  *-----------------------------------------------*\n"+
                        " 0    2   4   6   8  10  12  14  16  18  20  22  24"
        );


    }
}
