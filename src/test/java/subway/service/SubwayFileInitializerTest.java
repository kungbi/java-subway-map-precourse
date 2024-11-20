package subway.service;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import org.junit.jupiter.api.Test;
import subway.config.SubwayFileInitializer;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.utils.CsvReader;
import subway.utils.LineParser;
import subway.utils.Reader;
import subway.utils.StationParser;

class SubwayFileInitializerTest {

    @Test
    void initTest() {
        // given
        String stationData = "자양\n강남\n건대입구";
        Reader stationReader = new CsvReader(new BufferedReader(new CharArrayReader(stationData.toCharArray())), false);

        String lineData = "2호선,자양,강남,건대입구";
        Reader lineReader = new CsvReader(new BufferedReader(new CharArrayReader(lineData.toCharArray())), false);

        StationParser stationParser = new StationParser(stationReader);
        LineParser lineParser = new LineParser(lineReader);
        StationRepository stationRepository = new StationRepository();
        LineRepository lineRepository = new LineRepository();

        SubwayFileInitializer subwayFileInitializer = new SubwayFileInitializer(stationParser, lineParser,
                stationRepository, lineRepository);

        // when
        subwayFileInitializer.init();

        // then
        System.out.println(stationRepository.findAll());
        System.out.println(lineRepository.findAll());
    }

}