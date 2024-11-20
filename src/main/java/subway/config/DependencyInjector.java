package subway.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import subway.controller.SubwayController;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;
import subway.utils.CsvReader;
import subway.utils.LineParser;
import subway.utils.StationParser;

public class DependencyInjector {
    public SubwayController createSubwayController() {
        StationRepository stationRepository = new StationRepository();
        LineRepository lineRepository = new LineRepository();

        StationService stationService = new StationService(stationRepository);
        SectionService sectionService = new SectionService(lineRepository, stationRepository);
        LineService lineService = new LineService(lineRepository, stationRepository);

        SubwayFileInitializer subwayFileInitializer = createSubwayFileInitializer(stationRepository, lineRepository,
                stationService, sectionService);
        subwayFileInitializer.init();

        return new SubwayController(stationService, lineService, sectionService);
    }

    public SubwayFileInitializer createSubwayFileInitializer(StationRepository stationRepository,
                                                             LineRepository lineRepository,
                                                             StationService stationService,
                                                             SectionService sectionService) {
        StationParser stationParser = new StationParser(
                new CsvReader(this.createBufferedReader(Configuration.STATION_FILE_NAME.getString()),
                        false));
        LineParser lineParser = new LineParser(
                new CsvReader(this.createBufferedReader(Configuration.LINE_FILE_NAME.getString()), false));

        return new SubwayFileInitializer(
                stationParser, lineParser, stationRepository, lineRepository
        );
    }


    private BufferedReader createBufferedReader(String fileName) {
        return new BufferedReader(new InputStreamReader(
                DependencyInjector.class.getClassLoader().getResourceAsStream(fileName)
        ));
    }
}
