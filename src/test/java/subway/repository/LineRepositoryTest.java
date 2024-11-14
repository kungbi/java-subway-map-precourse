package subway.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.Station;

class LineRepositoryTest {

    @BeforeEach
    void setUp() {
        LineRepository.clear();
    }

    @Test
    void 정상__Line_추가() {
        // given
        LineRepository lineRepository = new LineRepository();

        // when
        Station station1 = new Station("강남역");
        Station station2 = new Station("논현역");
        Line line = new Line("1호선", station1, station2);
        lineRepository.add(line);

        // then
        Assertions.assertEquals(1, lineRepository.getSize());
    }

    @Test
    void 예외__중복된_Line_추가() {
        // given
        LineRepository lineRepository = new LineRepository();

        // when
        Station station1 = new Station("강남역");
        Station station2 = new Station("논현역");
        Line line = new Line("1호선", station1, station2);
        lineRepository.add(line);

        // then
        Line line2 = new Line("1호선", station1, station2);
        Assertions.assertThrows(IllegalArgumentException.class, () -> lineRepository.add(line2));
    }

    @Test
    void 정상__Line_삭제() {
        // given
        LineRepository lineRepository = new LineRepository();
        Station station1 = new Station("강남역");
        Station station2 = new Station("논현역");
        Line line1 = new Line("1호선", station1, station2);
        Line line2 = new Line("2호선", station1, station2);
        lineRepository.add(line1);
        lineRepository.add(line2);

        // when
        lineRepository.remove(line1);

        // then
        Assertions.assertEquals(1, lineRepository.getSize());
        Assertions.assertNotNull(lineRepository.findByName(line2.getName()));
    }
}