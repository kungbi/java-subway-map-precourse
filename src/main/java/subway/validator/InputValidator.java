package subway.validator;

public class InputValidator {

    public static void commandValidate(String command) {
        if (command == null || command.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

}
