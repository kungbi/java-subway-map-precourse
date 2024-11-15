package subway.config;

import subway.controller.SubwayController;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;

public class DependencyInjector {
    public SubwayController createSubwayController() {
        StationRepository stationRepository = new StationRepository();
        LineRepository lineRepository = new LineRepository();

        StationService stationService = new StationService(stationRepository);
        SectionService sectionService = new SectionService(lineRepository, stationRepository);
        LineService lineService = new LineService(lineRepository, stationRepository);

        return new SubwayController(stationService, lineService, sectionService);
    }
}
