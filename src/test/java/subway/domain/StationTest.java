package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StationTest {

    @Test
    void 정상__지하철_생성_테스트() {
        // given
        // when
        Station station = new Station("강남역");

        // then
        Assertions.assertEquals("강남역", station.getName());
    }

    @Test
    void 예외__지하철_이름_테스트() {
        // given
        // when
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Station("강"));
    }

}