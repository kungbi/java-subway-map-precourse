package subway.config;

public enum Configuration {
    LINE_NAME_MIN_LENGTH(2),
    STATION_NAME_MIN_LENGTH(2),
    ORDER_MIN_NUMBER(1),
    ;

    private final Object value;

    Configuration(Object value) {
        this.value = value;
    }

    public int getInt() {
        return (int) value;
    }
}
