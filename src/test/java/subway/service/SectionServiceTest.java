package subway.service;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.Station;
import subway.dto.SectionRegisterDto.SectionRegisterInputDto;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

class SectionServiceTest {
    StationRepository stationRepository;
    LineRepository lineRepository;

    @BeforeEach
    void setUp() {
        stationRepository = new StationRepository();
        Station station1 = new Station("강남역");
        Station station2 = new Station("논현역");
        Station station3 = new Station("강남구청역");
        stationRepository.add(station1);
        stationRepository.add(station2);
        stationRepository.add(station3);

        lineRepository = new LineRepository();
        Line line = new Line("1호선", station1, station2);

        lineRepository.add(line);
    }

    @Test
    void 정상__구간_추가() {
        // given
        SectionService sectionService = new SectionService(lineRepository, stationRepository);

        // when
        sectionService.register(new SectionRegisterInputDto("1호선", "강남구청역", 1));

        // then
        List<String> stationNames = lineRepository.findByName("1호선").getStationNames();
        Assertions.assertAll(
                () -> Assertions.assertEquals(3, stationNames.size()),
                () -> Assertions.assertEquals("강남구청역", stationNames.get(0)),
                () -> Assertions.assertEquals("강남역", stationNames.get(1)),
                () -> Assertions.assertEquals("논현역", stationNames.get(2))
        );

    }

}