import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void countStrike() {
        String twoStrikeInput = "423";
        int strikeCnt = baseBall.countStrike(twoStrikeInput);

        assertThat(strikeCnt).isEqualTo(2);
    }

    @Test
    void countBall() {
        String oneBallInput = "345";
        int ballCnt = baseBall.countBall(oneBallInput);

        assertThat(ballCnt).isEqualTo(1);
    }

    @Test
    void isCorrectAnswer() {
        assertThat(baseBall.isCorrectAnswer(defaultAnswer)).isTrue();
        assertThat(baseBall.isCorrectAnswer("456")).isFalse();
    }

    @Test
    void isStringNotEmpty() {
        assertThat(baseBall.isStringNotEmpty("")).isFalse();
        assertThat(baseBall.isStringNotEmpty("133")).isTrue();
    }

    private Boolean isDuplicateNumber(String value) {
        return value.charAt(0) == value.charAt(1) || value.charAt(1) == value.charAt(2) || value.charAt(2) == value.charAt(0);
    }

}
