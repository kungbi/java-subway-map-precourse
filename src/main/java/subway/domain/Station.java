package subway.domain;

import subway.validator.StationValidator;

public class Station {
    private String name;

    public Station(String name) {
        StationValidator.validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
