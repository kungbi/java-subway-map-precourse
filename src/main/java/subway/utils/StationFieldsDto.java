package subway.utils;


public record StationFieldsDto(String stationName) {
    public StationFieldsDto {
        if (stationName == null || stationName.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}