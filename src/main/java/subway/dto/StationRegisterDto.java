package subway.dto;

public class StationRegisterDto {
    public record StationRegisterInputDto(String stationName) {
    }

    public record StationRegisterOutputDto(int state) {
    }
}
