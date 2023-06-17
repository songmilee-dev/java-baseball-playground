import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BaseBall {

    final int SIZE = 3;

    private String answer;
    private InputView inputView;
    private ResultView resultView;

    public BaseBall(String defaultAnswer) {
        resultView = new ResultView();
        inputView = new InputView(System.in);
        answer = generateAnswer(defaultAnswer);
    }

    String generateAnswer(String defaultAnswer) {
        if(isStringNotEmpty(defaultAnswer)) {
            return defaultAnswer;
        }

        // 1 ~ 9 까지 숫자 생성
        Set<Integer> randomNumbers = new HashSet<>();
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        while(randomNumbers.size() < SIZE) {
            int randomValue = random.nextInt(8) + 1;
            if(!randomNumbers.contains(randomValue)) {
                randomNumbers.add(randomValue);
                sb.append(randomValue);
            }
        }
        return sb.toString();
    }

    Boolean isCorrectAnswer(String input) {
        return answer.equals(input);
    }

    int countStrike(String input) {
        int strikeCnt = 0;
        for(int i = 0; i < SIZE; i++) {
            if(answer.charAt(i) == input.charAt(i)) {
                strikeCnt += 1;
            }
        }

        return strikeCnt;
    }

    int countBall(String input) {
        int ballCnt = 0;
        for(int i = 0; i < SIZE; i++) {
            Character target = input.charAt(i);
            if(answer.charAt(i) != target && answer.indexOf(target) != -1) {
                ballCnt += 1;
            }
        }

        return ballCnt;
    }

    Boolean isStringNotEmpty(String value) {
        return value != null && value.length() > 0;
    }

    // UI
    Boolean doNewGameOrQuit() {
        resultView.printAskDoGameOrNot();
        return inputView.isPlayNewGame();
    }

    // UI
    void playGame() {
        boolean isAnswer = false;

        String input;
        while (!isAnswer){
            input = inputView.getCommand();
            isAnswer = isCorrectAnswer(input);
            if(isAnswer) {
                resultView.printCorrect();
                break;
            }

            resultView.printHint(countStrike(input), countBall(input));
        }

        if(doNewGameOrQuit()) {
            answer = generateAnswer("");
            playGame();
        }
    }
}
