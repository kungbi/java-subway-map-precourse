package subway.utils;

import java.io.IOException;
import java.util.List;

public class StationParser {
    public static final int STATION_NAME_INDEX = 0;

    private final Reader reader;

    public StationParser(Reader reader) {
        this.reader = reader;
    }

    public StationFieldsDto nextStation() throws IOException {
        List<String> fields = reader.readLine();
        if (fields == null || fields.isEmpty()) {
            return null;
        }
        validate(fields);
        return new StationFieldsDto(fields.get(STATION_NAME_INDEX));
    }

    private static void validate(List<String> fields) {
        if (fields.size() != 1) {
            throw new IllegalArgumentException();
        }
    }
}