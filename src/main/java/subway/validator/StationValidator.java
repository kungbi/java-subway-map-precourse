package subway.validator;

import subway.config.Configuration;
import subway.exception.GlobalExceptionMessage;
import subway.exception.StationExceptionMessage;

public class StationValidator {
    private StationValidator() {
    }

    public static void validate(String name) {
        if (name == null) {
            throw new IllegalArgumentException(GlobalExceptionMessage.NULL_POINTER.getMessage());
        }
        if (name.length() < Configuration.STATION_NAME_MIN_LENGTH.getInt()) {
            throw new IllegalArgumentException(StationExceptionMessage.NAME_LENGTH_MIN.getMessage());
        }
    }
}
