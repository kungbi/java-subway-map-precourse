package subway.service;

import java.util.List;
import subway.domain.Line;
import subway.domain.Station;
import subway.dto.LineRegisterDto.LineRegisterInputDto;
import subway.dto.LineRemoveDto.LineRemoveInputDto;
import subway.dto.LineRetrieveDto.LineRetrieveOutputDto;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class LineService {
    private final LineRepository lineRepository;
    private final StationRepository stationRepository;

    public LineService(LineRepository lineRepository, StationRepository stationRepository) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    public void register(LineRegisterInputDto input) {
        Station startStation = stationRepository.findByName(input.startStation().name());
        Station endStation = stationRepository.findByName(input.endStation().name());

        Line newLine = new Line(input.lineName(), startStation, endStation);
        lineRepository.add(newLine);
    }

    public void remove(LineRemoveInputDto input) {
        Line line = lineRepository.findByName(input.lineName());
        lineRepository.remove(line);
    }

    public LineRetrieveOutputDto retrieve() {
        List<Line> lines = lineRepository.findAll();
        return new LineRetrieveOutputDto(lines);
    }
}
