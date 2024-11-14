package subway;

import subway.controller.SubwayController;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.service.LineService;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        StationRepository stationRepository = new StationRepository();
        LineRepository lineRepository = new LineRepository();
        StationService stationService = new StationService(stationRepository);
        LineService lineService = new LineService(lineRepository, stationRepository);

        SubwayController subwayController = new SubwayController(inputView, outputView, stationService, lineService);
        subwayController.run();
    }
}
