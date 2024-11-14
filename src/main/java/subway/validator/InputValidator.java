package subway.validator;

public class InputValidator {

    public static void commandValidate(String command) {
        nullValidate(command);
    }

    public static void nullValidate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 NULL이거나 빈 문자열 입니다.");
        }
    }


}
