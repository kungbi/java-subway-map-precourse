package subway.exception;

public class ReaderException extends IllegalArgumentException {
    private static final String DEFAULT_MESSAGE = "파일을 읽는 과정에서 문제가 발생하였습니다.";

    public ReaderException() {
        super(DEFAULT_MESSAGE);
    }

    public ReaderException(String message) {
        super(message);
    }
}
