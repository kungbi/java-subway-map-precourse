package subway.dto;

public class LineRegisterDto {
    public record LineRegisterInputDto(String lineName, StationDto startStation, StationDto endStation) {
    }
}
