package subway.validator;

import java.util.Objects;
import subway.domain.Station;

public class LineValidator {
    private LineValidator() {
    }

    public static void validate(String name, Station startStation, Station endStation) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException();
        }
        if (startStation == null || endStation == null) {
            throw new IllegalArgumentException();
        }
        if (Objects.equals(startStation.getName(), endStation.getName())) {
            throw new IllegalArgumentException();
        }
    }
}
