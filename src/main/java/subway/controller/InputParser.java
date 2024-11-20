package subway.controller;

import subway.exception.GlobalExceptionMessage;

public class InputParser {

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(GlobalExceptionMessage.NUMBER_FORMAT.getMessage(), error);
        }
    }

}
