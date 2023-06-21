package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTests {
    private Ball ball;

    @BeforeEach
    void setUp() {
        ball = new Ball(1, 1);
    }

    @Test
    void strike() {
        assertThat(ball.judge(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        assertThat(ball.judge(new Ball(2, 1))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        assertThat(ball.judge(new Ball(1, 3))).isEqualTo(BallStatus.NOTHING);
    }
}
