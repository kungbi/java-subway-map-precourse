package subway.dto;

import java.util.List;

public class StationRetrieveDto {
    public record StationRetrieveOutputDto(List<StationDto> stations) {
    }
}
