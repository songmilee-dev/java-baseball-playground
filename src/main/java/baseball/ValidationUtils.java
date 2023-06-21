package baseball;

public class ValidationUtils {
    final static int MIN_VALUE = 1;
    final static int MAX_VALUE = 9;

    public static boolean isValid(int no) {
        if (no >= MIN_VALUE && no <= MAX_VALUE) {
            return true;
        }
        return false;
    }
}
