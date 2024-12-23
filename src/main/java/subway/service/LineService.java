package subway.service;

import java.util.List;
import subway.domain.Line;
import subway.domain.Station;
import subway.dto.LineDto;
import subway.dto.LineRegisterDto.LineRegisterInputDto;
import subway.dto.LineRemoveDto.LineRemoveInputDto;
import subway.dto.LineRetrieveDto.LineRetrieveOutputDto;
import subway.exception.LineExceptionMessage;
import subway.exception.StationExceptionMessage;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class LineService {
    private final LineRepository lineRepository;
    private final StationRepository stationRepository;

    public LineService(LineRepository lineRepository, StationRepository stationRepository) {
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    public boolean isLineExist(String name) {
        Line line = lineRepository.findByName(name);
        return line != null;
    }

    public void register(LineRegisterInputDto input) {
        Station startStation = stationRepository.findByName(input.startStation());
        if (startStation == null) {
            throw new IllegalArgumentException(
                    String.format(StationExceptionMessage.NOT_EXIST_STATION.getMessage(), input.startStation()));
        }

        Station endStation = stationRepository.findByName(input.endStation());
        if (endStation == null) {
            throw new IllegalArgumentException(
                    String.format(StationExceptionMessage.NOT_EXIST_STATION.getMessage(), input.endStation()));
        }

        Line newLine = new Line(input.lineName(), startStation, endStation);
        lineRepository.add(newLine);
    }

    public void remove(LineRemoveInputDto input) {
        if (lineRepository.findByName(input.lineName()) == null) {
            throw new IllegalArgumentException(
                    String.format(LineExceptionMessage.NOT_EXIST_LINE.getMessage(), input.lineName()));
        }
        Line line = lineRepository.findByName(input.lineName());
        lineRepository.remove(line);
    }

    public LineRetrieveOutputDto retrieve() {
        List<Line> lines = lineRepository.findAll();
        List<LineDto> linesDto = lines.stream().map(LineDto::from).toList();
        return new LineRetrieveOutputDto(linesDto);
    }


}
