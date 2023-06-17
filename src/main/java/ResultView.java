public class ResultView {
    private void printBall(int ballCount) {
        if(ballCount == 0) return;
        System.out.print(ballCount +" 볼 ");
    }

    private void printStrike(int strikeCount) {
        if(strikeCount == 0) return;
        System.out.print(strikeCount + " 스트라이크 ");
    }

    private void printNothing() {
        System.out.println("낫싱");
    }

    public void printCorrect() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printAskDoGameOrNot() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printHint(int strikeCount, int ballCount) {
        if(strikeCount + ballCount == 0) {
            printNothing();
            return;
        }

        printBall(ballCount);
        printStrike(strikeCount);
    }
}
