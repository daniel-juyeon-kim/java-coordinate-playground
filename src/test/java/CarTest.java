import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void calculateFillOilTest() {
        assertThat(new Avante(15).calculateOilForMoving()).isEqualTo(1);
        assertThat(new Avante(45).calculateOilForMoving()).isEqualTo(3);

        assertThat(new Sonata(10).calculateOilForMoving()).isEqualTo(1);
        assertThat(new Sonata(100).calculateOilForMoving()).isEqualTo(10);

        assertThat(new K5(13).calculateOilForMoving()).isEqualTo(1);
        assertThat(new K5(26).calculateOilForMoving()).isEqualTo(2);
    }
}
