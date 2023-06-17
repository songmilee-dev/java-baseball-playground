import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BaseBall {

    final int SIZE = 3;

    private String answer;
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
    int countStrike(String input) {
        int strikeCnt = 0;
        for(int i = 0; i < SIZE; i++) {
            if(answer.charAt(i) == input.charAt(i)) {
                strikeCnt += 1;
            }
        }

        return strikeCnt;
    }
}
