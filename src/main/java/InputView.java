import java.io.InputStream;
import java.util.Scanner;

public class InputView {
    final String NEW_GAME = "1";
    final String QUIT_GAME = "2";
    private Scanner scanner;

    public InputView(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public String getCommand() {
        System.out.print("숫자를 입력해 주세요 : ");
        return scanner.nextLine();
    }

    public Boolean isPlayNewGame() {
        String command;
        do {
            command = scanner.nextLine();
        } while (command.contains(NEW_GAME) || command.contains(QUIT_GAME));

        return command.contains(NEW_GAME);
    }
}
