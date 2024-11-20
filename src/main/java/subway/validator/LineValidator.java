package subway.validator;

import java.util.Objects;
import subway.config.Configuration;
import subway.domain.Station;
import subway.exception.GlobalExceptionMessage;

public class LineValidator {
    private LineValidator() {
    }

    public static void validate(String name, Station startStation, Station endStation) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name.length() < Configuration.LINE_NAME_MIN_LENGTH.getInt()) {
            throw new IllegalArgumentException();
        }
        if (startStation == null || endStation == null) {
            throw new IllegalArgumentException(GlobalExceptionMessage.NULL_POINTER.getMessage());
        }
        if (Objects.equals(startStation.getName(), endStation.getName())) {
            throw new IllegalArgumentException();
        }
    }
}
