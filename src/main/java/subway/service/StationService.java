package subway.service;

import java.util.List;
import subway.domain.Station;
import subway.dto.StationDto;
import subway.dto.StationRegisterDto.StationRegisterInputDto;
import subway.dto.StationRemoveDto.StationRemoveInputDto;
import subway.dto.StationRetrieveDto.StationRetrieveOutputDto;
import subway.repository.StationRepository;

public class StationService {
    private final StationRepository stationRepository;

    public StationService(StationRepository repository) {
        this.stationRepository = repository;
    }

    public void register(StationRegisterInputDto input) {
        Station newStation = new Station(input.stationName());
        this.stationRepository.add(newStation);
    }

    public void remove(StationRemoveInputDto input) {
        Station station = stationRepository.findByName(input.stationName());
        stationRepository.remove(station);
    }

    public StationRetrieveOutputDto retrieve() {
        List<Station> stations = this.stationRepository.findAll();
        List<StationDto> stationsDto = stations.stream().map(StationDto::from).toList();

        return new StationRetrieveOutputDto(stationsDto);
    }

}
