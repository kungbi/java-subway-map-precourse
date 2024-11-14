package subway.service;

import java.util.List;
import subway.domain.Station;
import subway.dto.StationDto;
import subway.dto.StationRegisterDto.StationRegisterInputDto;
import subway.dto.StationRemoveDto.StationRemoveInputDto;
import subway.dto.StationRetrieveDto.StationRetrieveOutputDto;
import subway.repository.StationRepository;

public class StationService {
    private final StationRepository repository;

    public StationService(StationRepository repository) {
        this.repository = repository;
    }

    public void register(StationRegisterInputDto input) {
        Station newStation = new Station(input.stationName());
        this.repository.add(newStation);
    }

    public void remove(StationRemoveInputDto input) {
        repository.deleteStation(input.stationName());
    }

    public StationRetrieveOutputDto retrieve() {
        List<Station> stations = this.repository.findAll();
        List<StationDto> stationsDto = stations.stream().map(StationDto::from).toList();

        return new StationRetrieveOutputDto(stationsDto);
    }

}
