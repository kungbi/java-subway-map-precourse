package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.dto.SectionRegisterDto.SectionRegisterInputDto;
import subway.dto.SectionRemoveDto.SectionRemoveInputDto;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class SectionService {
    private final LineRepository lineRepository;
    private final StationRepository stationRepository;

    public SectionService(LineRepository lineRepository, StationRepository stationRepository) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    public void register(SectionRegisterInputDto input) {
        Line line = this.lineRepository.findByName(input.lineName());
        if (line == null) {
            throw new IllegalArgumentException("노선이 없습니다.");
        }

        Station station = this.stationRepository.findByName(input.stationName());
        if (station == null) {
            throw new IllegalArgumentException("정류장이 없습니다.");
        }

        int index = input.orderNumber() - 1;
        lineRepository.addStation(line, station, index);
    }

    public void remove(SectionRemoveInputDto input) {
        Line line = this.lineRepository.findByName(input.lineName());
        if (line == null) {
            throw new IllegalArgumentException("노선이 없습니다.");
        }

        Station station = this.stationRepository.findByName(input.lineName());
        if (station == null) {
            throw new IllegalArgumentException("정류장이 없습니다.");
        }

        lineRepository.removeStation(line, station);
    }
}
