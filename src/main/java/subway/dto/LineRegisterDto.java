package subway.dto;

public class LineRegisterDto {
    public record LineRegisterInputDto(String lineName, String startStation, String endStation) {
    }
}
