package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ValidationUtilTests {
    @Test
    void validNo() {
        assertThat(ValidationUtils.isValid(1)).isTrue();
        assertThat(ValidationUtils.isValid(9)).isTrue();
        assertThat(ValidationUtils.isValid(0)).isFalse();
        assertThat(ValidationUtils.isValid(10)).isFalse();
    }
}
