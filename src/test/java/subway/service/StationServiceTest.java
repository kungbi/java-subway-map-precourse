package subway.service;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.domain.Station;
import subway.dto.StationDto;
import subway.dto.StationRegisterDto.StationRegisterInputDto;
import subway.dto.StationRemoveDto.StationRemoveInputDto;
import subway.dto.StationRetrieveDto.StationRetrieveOutputDto;
import subway.repository.StationRepository;

class StationServiceTest {

    @BeforeEach
    void setUp() {
        StationRepository.clear();
    }

    @Test
    void 정상__정류장_등록() {
        // given
        StationRepository stationRepository = new StationRepository();
        StationService stationService = new StationService(stationRepository);

        // when
        stationService.register(new StationRegisterInputDto("강남역"));

        // then
        Station result = stationRepository.findByName("강남역");
        Assertions.assertEquals("강남역", result.getName());
    }

    @Test
    void 정상__정류장_삭제() {
        // given
        StationRepository stationRepository = new StationRepository();
        StationService stationService = new StationService(stationRepository);
        stationService.register(new StationRegisterInputDto("강남역"));
        stationService.register(new StationRegisterInputDto("홍대입구"));

        // when
        stationService.remove(new StationRemoveInputDto("홍대입구"));

        // then
        Station result = stationRepository.findByName("홍대입구");
        Assertions.assertNull(result);
    }


    @Test
    void 정상__정류장_조회() {
        // given
        StationRepository stationRepository = new StationRepository();
        StationService stationService = new StationService(stationRepository);
        stationService.register(new StationRegisterInputDto("강남역"));
        stationService.register(new StationRegisterInputDto("홍대입구"));

        // when
        List<StationDto> stations = stationService.retrieve().stations();

        // then
        Assertions.assertTrue(stations.stream().anyMatch(station -> station.name().equals("강남역")));
        Assertions.assertTrue(stations.stream().anyMatch(station -> station.name().equals("홍대입구")));
    }

}