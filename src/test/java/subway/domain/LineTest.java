package subway.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void 정상__생성_테스트() {
        // given
        Station station1 = new Station("강남역");
        Station station2 = new Station("논현역");
        Line line = new Line("1호선", station1, station2);

        // then
        Assertions.assertEquals("1호선", line.getName());
    }

    @Test
    void 예외__이름_길이() {
        // given
        Station station1 = new Station("강남역");
        Station station2 = new Station("논현역");

        // when
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Line("아", station1, station2));
    }

    @Test
    void 정상__역_추가하기() {
        // given
        Station station1 = new Station("강남역");
        Station station2 = new Station("논현역");
        Line line = new Line("1호선", station1, station2);

        // when
        Station station3 = new Station("강남구청");
        line.addStation(station3);

        // then
        List<String> stationNames = line.getStationNames();
        Assertions.assertAll(
                () -> Assertions.assertEquals("강남역", stationNames.get(0)),
                () -> Assertions.assertEquals("논현역", stationNames.get(1)),
                () -> Assertions.assertEquals("강남구청", stationNames.get(2))
        );
    }

    @Test
    void 정상__역_중간에_추가하기() {
        // given
        Station station1 = new Station("강남역");
        Station station2 = new Station("논현역");
        Line line = new Line("1호선", station1, station2);

        // when
        Station station3 = new Station("강남구청");
        line.addStation(station3, 1);

        // then
        List<String> stationNames = line.getStationNames();
        Assertions.assertAll(
                () -> Assertions.assertEquals("강남역", stationNames.get(0)),
                () -> Assertions.assertEquals("강남구청", stationNames.get(1)),
                () -> Assertions.assertEquals("논현역", stationNames.get(2))
        );
    }


    @Test
    void 정상__역_삭제하기() {
        // given
        Station station1 = new Station("강남역");
        Station station2 = new Station("논현역");
        Station station3 = new Station("강남구청");
        Line line = new Line("1호선", station1, station2);
        line.addStation(station3);

        // when
        line.removeStation(station3);

        // then
        List<String> stationNames = line.getStationNames();
        Assertions.assertAll(
                () -> Assertions.assertEquals("강남역", stationNames.get(0)),
                () -> Assertions.assertEquals("논현역", stationNames.get(1))
        );
    }


    @Test
    void 정상__역_개수() {
        // given
        Station station1 = new Station("강남역");
        Station station2 = new Station("논현역");
        Station station3 = new Station("강남구청");
        Line line = new Line("1호선", station1, station2);
        line.addStation(station3);

        // when
        int stationCount = line.getStationCount();

        // then
        Assertions.assertEquals(3, stationCount);
    }

}