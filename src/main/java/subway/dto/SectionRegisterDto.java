package subway.dto;

public class SectionRegisterDto {
    public record SectionRegisterInputDto(String lineName, String stationName, int orderNumber) {
    }
}
