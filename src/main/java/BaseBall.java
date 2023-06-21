import com.sun.tools.javac.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

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
        if (isStringNotEmpty(defaultAnswer)) {
            return defaultAnswer;
        }

        // 1 ~ 9 까지 숫자 생성
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> numList = Arrays.asList(numbers);
        Collections.shuffle(numList);

        return numList.subList(0, 3)
                .stream()
                .map(i -> String.valueOf(i))
                .collect(Collectors.joining());
    }

    Boolean isCorrectAnswer(String input) {
        return answer.equals(input);
    }

    int countStrike(String input) {
        int strikeCnt = 0;
        for (int i = 0; i < SIZE; i++) {
            if (answer.charAt(i) == input.charAt(i)) {
                strikeCnt += 1;
            }
        }

        return strikeCnt;
    }

    int countBall(String input) {
        int ballCnt = 0;
        for (int i = 0; i < SIZE; i++) {
            Character target = input.charAt(i);
            if (answer.charAt(i) != target && answer.indexOf(target) != -1) {
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
        while (!isAnswer) {
            input = inputView.getCommand();
            if (input.length() != 3) continue;

            isAnswer = isCorrectAnswer(input);
            if (isAnswer) {
                resultView.printCorrect();
                break;
            }

            resultView.printHint(countStrike(input), countBall(input));
        }

        if (doNewGameOrQuit()) {
            answer = generateAnswer("");
            playGame();
        }
    }
}
