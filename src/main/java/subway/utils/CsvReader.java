package subway.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import subway.exception.ReaderException;

public class CsvReader implements Reader {
    private final BufferedReader reader;

    public CsvReader(BufferedReader reader, boolean header) {
        if (reader == null) {
            throw new subway.exception.ReaderException();
        }
        this.reader = reader;
        if (header) {
            skipHeader();
        }
    }

    // public methods

    @Override
    public List<String> readLine() throws IOException {
        String line = this.reader.readLine();
        if (line == null) {
            return null;
        }

        return List.of(line.split(","));
    }

    @Override
    public void close() throws IOException {
        this.reader.close();
    }

    // private methods

    private void skipHeader() {
        try {
            this.reader.readLine();
        } catch (IOException error) {
            throw new ReaderException();
        }
    }
}