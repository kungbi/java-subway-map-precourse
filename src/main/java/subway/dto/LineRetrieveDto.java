package subway.dto;

import java.util.List;

public class LineRetrieveDto {
    public record LineRetrieveOutputDto(List<LineDto> lines) {
    }
}
