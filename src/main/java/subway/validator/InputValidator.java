package subway.validator;

public class InputValidator {

    public static void mainCommandValidate(String command) {
        if (!"1234Q".contains(command)) {
            throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
        }
    }

}
