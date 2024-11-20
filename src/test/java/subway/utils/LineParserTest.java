package subway.utils;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LineParserTest {

    @Test
    void 노선_정보_읽기() throws IOException {
        // given
        String data = "2호선,교대역,강남역,역삼역\n3호선,교대역,남부터미널역,양재역,매봉역";
        Reader reader = new CsvReader(new BufferedReader(new CharArrayReader(data.toCharArray())), false);
        LineParser lineParser = new LineParser(reader);

        // when
        LineFieldsDto lineFieldsDto = lineParser.nextLine();

        // then
        Assertions.assertEquals("2호선", lineFieldsDto.lineName());
        Assertions.assertEquals(3, lineFieldsDto.stationNames().size());
        Assertions.assertEquals(List.of("교대역", "강남역", "역삼역"), lineFieldsDto.stationNames());
    }

}