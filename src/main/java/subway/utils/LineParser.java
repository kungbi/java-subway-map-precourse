package subway.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineParser {
    public static final int LINE_NAME_INDEX = 0;

    private final Reader reader;

    public LineParser(Reader reader) {
        this.reader = reader;
    }

    public LineFieldsDto nextLine() throws IOException {
        List<String> fields = reader.readLine();
        if (fields == null || fields.isEmpty()) {
            return null;
        }
        validate(fields);

        List<String> stations = new ArrayList<>();
        for (int i = 1; i < fields.size(); i++) {
            stations.add(fields.get(i));
        }
        return new LineFieldsDto(
                fields.get(LINE_NAME_INDEX), stations
        );
    }

    private static void validate(List<String> fields) {
        if (fields.size() < 3) {
            throw new IllegalArgumentException();
        }
    }
}