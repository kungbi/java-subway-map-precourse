package subway.dto;

import subway.domain.Station;

public record StationDto(String name) {
    public StationDto {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("DTO: station name is null");
        }
    }

    public static StationDto from(Station station) {
        return new StationDto(station.getName());
    }
}
