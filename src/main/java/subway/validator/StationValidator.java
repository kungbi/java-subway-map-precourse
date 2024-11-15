package subway.validator;

public class StationValidator {
    private StationValidator() {
    }

    public static void validate(String name) {
        if (name == null) {
            throw new IllegalArgumentException("역의 이름이 NULL");
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException("역의 이름은 2자 이상이어야 함.");
        }
    }
}
