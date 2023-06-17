import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallTest {
    final String defaultAnswer = "123";
    private BaseBall baseBall = new BaseBall(defaultAnswer);

    @Test
    void generateAnswerWithDefault() {
        String answer = "456";
        String actual = baseBall.generateAnswer(answer);

        assertThat(actual.length()).isEqualTo(3);
        assertThat(actual).isEqualTo(answer);
    }

    @Test
    void generateAnswer() {
        String actual = baseBall.generateAnswer(null);

        assertThat(actual.length()).isEqualTo(3);
        assertThat(isDuplicateNumber(actual)).isFalse();
    }

    private Boolean isDuplicateNumber(String value) {
        return value.charAt(0) == value.charAt(1) || value.charAt(1) == value.charAt(2) || value.charAt(2) == value.charAt(0);
    }
}
