package subway.dto;

import java.util.List;
import subway.domain.Line;

public class LineRetrieveDto {
    public record LineRetrieveOutputDto(List<Line> lines) {
    }
}
