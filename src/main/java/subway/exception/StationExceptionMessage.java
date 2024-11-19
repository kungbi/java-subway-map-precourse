package subway.exception;

public enum StationExceptionMessage implements ExceptionMessage {
    NAME_LENGTH_MIN("역의 이름은 2자 이상이어야 함."),
    EXIST_STATION_NAME("이미 등록된 역 이름입니다."),
    NOT_FOUND_STATION("정류장이 없습니다."),
    NOT_EXIST_STATION("%s 정류장은 존재하지 않습니다.");

    private final String message;

    StationExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "";
    }
}
