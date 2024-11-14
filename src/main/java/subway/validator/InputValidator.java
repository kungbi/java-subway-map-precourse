package subway.validator;

public class InputValidator {

    public static void commandValidate(String command) {
        nullValidate(command);
    }

    public static void orderNumberValidate(int orderNumber) {
        if (orderNumber < 1) {
            throw new IllegalArgumentException("1이상의 값을 입력해야 합니다.");
        }
    }

    public static void nullValidate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 NULL이거나 빈 문자열 입니다.");
        }
    }


}
