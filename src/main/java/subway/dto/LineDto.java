package subway.dto;

import java.util.List;
import subway.domain.Line;

public record LineDto(String name, List<StationDto> stations) {
    public LineDto {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("DTO: name is null");
        }
        if (stations == null || stations.isEmpty()) {
            throw new IllegalArgumentException("DTO: stations is null");
        }
    }

    public static LineDto from(Line line) {
        List<StationDto> stations = line.getStations().stream().map(StationDto::from).toList();
        return new LineDto(line.getName(), stations);
    }
}