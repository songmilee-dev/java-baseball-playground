package baseball;

import java.util.Objects;

public class Ball {
    int position;
    int no;

    public Ball(int position, int no) {
        this.position = position;
        this.no = no;
    }

    public BallStatus judge(Ball ball) {
        if(equals(ball)) {
            return BallStatus.STRIKE;
        }

        if(isBall(ball)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    boolean isBall(Ball ball) {
        if(ball == null) {
            throw new IllegalArgumentException("Ball은 null 이어서는 안됩니다.");
        }
        return no == ball.no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position &&
                no == ball.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, no);
    }
}
