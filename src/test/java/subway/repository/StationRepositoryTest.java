package subway.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import subway.domain.Station;

class StationRepositoryTest {

    @Test
    void 정상__역_추가() {
        // given
        StationRepository repository = new StationRepository();

        // when
        Station station1 = new Station("강남역");
        Station station2 = new Station("논현역");
        repository.add(station1);
        repository.add(station2);

        // then
        Assertions.assertEquals(2, repository.getSize());
    }

    @Test
    void 예외__역_이름_중복() {
        // given
        StationRepository repository = new StationRepository();

        // when
        Station station1 = new Station("강남역");
        Station station2 = new Station("강남역");
        repository.add(station1);

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> repository.add(station2));
    }

    @Test
    void 정상_역_삭제() {
        // given
        StationRepository repository = new StationRepository();
        Station station1 = new Station("강남역");
        Station station2 = new Station("논현역");
        repository.add(station1);
        repository.add(station2);

        // when
        repository.remove(station1);

        // then
        Assertions.assertEquals(1, repository.getSize());
        Assertions.assertNotNull(repository.findByName(station2.getName()));
    }

}