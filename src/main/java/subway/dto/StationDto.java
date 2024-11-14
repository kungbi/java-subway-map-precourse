package subway.dto;

import subway.domain.Station;

public record StationDto(String name) {

    public static StationDto from(Station station) {
        return new StationDto(station.getName());
    }
}
