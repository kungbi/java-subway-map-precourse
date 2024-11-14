package subway;

import subway.controller.SubwayController;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;

public class Application {
    public static void main(String[] args) {
        StationRepository stationRepository = new StationRepository();
        LineRepository lineRepository = new LineRepository();
        StationService stationService = new StationService(stationRepository);
        SectionService sectionService = new SectionService(lineRepository, stationRepository);
        LineService lineService = new LineService(lineRepository, stationRepository);

        SubwayController subwayController = new SubwayController(stationService, lineService, sectionService);
        subwayController.run();
    }
}
