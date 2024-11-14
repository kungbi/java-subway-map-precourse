package subway.controller;

import java.util.List;
import subway.command.LineCommand;
import subway.command.MainCommand;
import subway.command.SectionCommand;
import subway.command.StationCommand;
import subway.dto.StationDto;
import subway.dto.StationRegisterDto.StationRegisterInputDto;
import subway.dto.StationRemoveDto.StationRemoveInputDto;
import subway.service.LineService;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RetryInputUtil retryInputUtil;
    private final StationService stationService;
    private final LineService lineService;

    public SubwayController(InputView inputView, OutputView outputView, StationService stationService,
                            LineService lineService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stationService = stationService;
        this.lineService = lineService;
        this.retryInputUtil = new RetryInputUtil(inputView, outputView);
    }

    public void run() {
        int state = 0;

        while (state == 0) {
            try {
                outputView.printMainMenu();
                MainCommand mainCommand = MainCommand.find(retryInputUtil.getMainCommand());

                state = mainLogic(mainCommand);
            } catch (IllegalArgumentException error) {
                outputView.printError(error.getMessage());
            }
        }
    }

    private int mainLogic(MainCommand mainCommand) {
        if (mainCommand == MainCommand.QUIT) {
            return 1;
        }

        if (mainCommand == MainCommand.STATION) {
            outputView.printStationManageMenu();
            StationCommand stationCommand = StationCommand.find(retryInputUtil.getStationCommand());
            this.stationLogic(stationCommand);
        }
        if (mainCommand == MainCommand.LINE) {
            outputView.printLineManageMenu();
            LineCommand lineCommand = LineCommand.find(retryInputUtil.getLineCommand());
        }
        if (mainCommand == MainCommand.SECTION) {
            outputView.printSectionManageMenu();
            SectionCommand sectionCommand = SectionCommand.find(retryInputUtil.getSectionCommand());
        }
        if (mainCommand == MainCommand.LINE_PRINT) {
            // outputview에 구현 해야함.
        }

        return 0;
    }

    private void stationLogic(StationCommand stationCommand) {
        if (stationCommand == StationCommand.BACK) {
            return;
        }

        if (stationCommand == StationCommand.REGISTER) {
            String stationName = retryInputUtil.getRegisterStationName();
            stationService.register(new StationRegisterInputDto(stationName));
        }
        if (stationCommand == StationCommand.REMOVE) {
            String stationName = retryInputUtil.getRemoveStationName();
            stationService.remove(new StationRemoveInputDto(stationName));
        }
        if (stationCommand == StationCommand.RETRIEVE) {
            List<StationDto> stations = stationService.retrieve().stations();
            outputView.printStations(stations);
        }
    }


}
