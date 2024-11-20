package subway.config;

public enum Configuration {
    STATION_FILE_NAME("stations.md"),
    LINE_FILE_NAME("lines.md"),
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

    public String getString() {
        return (String) value;
    }
}
