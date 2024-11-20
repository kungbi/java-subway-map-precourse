package subway.utils;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StationParserTest {

    @Test
    void 역_정보_읽기() throws IOException {
        // given
        String data = "자양\n강남\n건대입구";
        Reader reader = new CsvReader(new BufferedReader(new CharArrayReader(data.toCharArray())), false);
        StationParser stationParser = new StationParser(reader);

        // when
        StationFieldsDto stationFieldsDto = stationParser.nextStation();

        // then
        Assertions.assertEquals("자양", stationFieldsDto.stationName());
    }

}