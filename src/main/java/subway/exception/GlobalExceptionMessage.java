package subway.exception;

public enum GlobalExceptionMessage implements ExceptionMessage {
    NULL_POINTER("NULL 값이 입력되었습니다."),
    NUMBER_FORMAT("문자가 포함되어 있거나 정수 범위를 넘었습니다.");


    private final String message;

    GlobalExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
