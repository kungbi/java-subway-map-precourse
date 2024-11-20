package subway.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import subway.domain.Line;
import subway.domain.Station;
import subway.exception.ReaderException;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.utils.LineFieldsDto;
import subway.utils.LineParser;
import subway.utils.StationFieldsDto;
import subway.utils.StationParser;

public class SubwayFileInitializer {
    private final StationParser stationParser;
    private final LineParser lineParser;
    private final StationRepository stationRepository;
    private final LineRepository lineRepository;

    public SubwayFileInitializer(StationParser stationParser, LineParser lineParser,
                                 StationRepository stationRepository, LineRepository lineRepository) {
        this.stationParser = stationParser;
        this.lineParser = lineParser;
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
    }

    public void init() {
        try {
            initStations();
            initLines();
        } catch (IOException e) {
            throw new ReaderException();
        } catch (IllegalArgumentException error) {
            throw new IllegalArgumentException(error.getMessage());
        }
    }

    private void initStations() throws IOException {
        while (true) {
            StationFieldsDto stationFieldsDto = stationParser.nextStation();
            if (stationFieldsDto == null) {
                break;
            }

            stationRepository.add(new Station(stationFieldsDto.stationName()));
        }
    }

    private void initLines() throws IOException {
        while (true) {
            LineFieldsDto lineFieldsDto = lineParser.nextLine();
            if (lineFieldsDto == null) {
                break;
            }

            List<Station> stations = new ArrayList<>();
            for (String stationName : lineFieldsDto.stationNames()) {
                Station station = stationRepository.findByName(stationName);
                if (station == null) {
                    throw new IllegalArgumentException();
                }

                stations.add(station);
            }

            Line line = new Line(lineFieldsDto.lineName(), stations.getFirst(), stations.getLast());
            lineRepository.add(line);
            for (int i = 1; i < stations.size(); i++) {
                Station station = stations.get(i);
                lineRepository.addStation(line, station, i);
            }
        }
    }

}
