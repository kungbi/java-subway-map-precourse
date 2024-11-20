package subway.validator;

import subway.config.Configuration;
import subway.exception.GlobalExceptionMessage;
import subway.exception.StationExceptionMessage;

public class InputValidator {

    public static void commandValidate(String command) {
        nullValidate(command);
    }

    public static void orderNumberValidate(int orderNumber) {
        if (orderNumber < Configuration.ORDER_MIN_NUMBER.getInt()) {
            throw new IllegalArgumentException(StationExceptionMessage.NAME_LENGTH_MIN.getMessage());
        }
    }

    public static void nullValidate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(GlobalExceptionMessage.NULL_POINTER.getMessage());
        }
    }


}
