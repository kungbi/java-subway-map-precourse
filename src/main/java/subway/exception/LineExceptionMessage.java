package subway.exception;

public enum LineExceptionMessage implements ExceptionMessage {
    NOT_FOUND_LINE("노선이 없습니다."),
    EXIST_LINE_NAME("이미 등록된 노선 이름입니다."),
    NOT_EXIST_LINE("%s 노선은 존재하지 않습니다.");

    private final String message;

    LineExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
