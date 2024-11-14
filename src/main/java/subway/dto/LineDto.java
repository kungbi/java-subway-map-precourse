package subway.dto;

import java.util.List;
import subway.domain.Line;

public record LineDto(String name, List<StationDto> stations) {

    public static LineDto from(Line line) {
        List<StationDto> stations = line.getStations().stream().map(StationDto::from).toList();
        return new LineDto(line.getName(), stations);
    }
}