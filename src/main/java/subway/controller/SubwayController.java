package subway.controller;

import java.util.List;
import subway.command.LineCommand;
import subway.command.MainCommand;
import subway.command.SectionCommand;
import subway.command.StationCommand;
import subway.controller.retryInputUtil.LineRetryInput;
import subway.controller.retryInputUtil.RetryInputUtil;
import subway.controller.retryInputUtil.SectionRetryInput;
import subway.controller.retryInputUtil.StationRetryInput;
import subway.dto.LineDto;
import subway.dto.LineRegisterDto.LineRegisterInputDto;
import subway.dto.LineRemoveDto.LineRemoveInputDto;
import subway.dto.StationDto;
import subway.dto.StationRegisterDto.StationRegisterInputDto;
import subway.dto.StationRemoveDto.StationRemoveInputDto;
import subway.service.LineService;
import subway.service.StationService;
import subway.view.OutputView;

public class SubwayController {
    private final StationService stationService;
    private final LineService lineService;

    public SubwayController(StationService stationService, LineService lineService) {
        this.stationService = stationService;
        this.lineService = lineService;
    }

    public void run() {
        int state = 0;

        while (state == 0) {
            try {
                OutputView.printMainMenu();
                MainCommand mainCommand = MainCommand.find(RetryInputUtil.getMainCommand());

                state = mainLogic(mainCommand);
            } catch (IllegalArgumentException error) {
                OutputView.printError(error.getMessage());
            }
        }
    }

    private int mainLogic(MainCommand mainCommand) {
        if (mainCommand == MainCommand.QUIT) {
            return 1;
        }

        if (mainCommand == MainCommand.STATION) {
            OutputView.printStationManageMenu();
            StationCommand stationCommand = StationCommand.find(StationRetryInput.getCommand());
            this.stationLogic(stationCommand);
        }
        if (mainCommand == MainCommand.LINE) {
            OutputView.printLineManageMenu();
            LineCommand lineCommand = LineCommand.find(LineRetryInput.getCommand());
            this.lineLogic(lineCommand);
        }
        if (mainCommand == MainCommand.SECTION) {
            OutputView.printSectionManageMenu();
            SectionCommand sectionCommand = SectionCommand.find(SectionRetryInput.getCommand());
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
            String stationName = StationRetryInput.getStationName();
            stationService.register(new StationRegisterInputDto(stationName));
        }
        if (stationCommand == StationCommand.REMOVE) {
            String stationName = StationRetryInput.getRemoveStationName();
            stationService.remove(new StationRemoveInputDto(stationName));
            OutputView.printStationRemovedMessage();
        }
        if (stationCommand == StationCommand.RETRIEVE) {
            List<StationDto> stations = stationService.retrieve().stations();
            OutputView.printStations(stations);
        }
    }

    private void lineLogic(LineCommand lineCommand) {
        if (lineCommand == LineCommand.BACK) {
            return;
        }

        if (lineCommand == LineCommand.REGISTER) {
            String lineName = LineRetryInput.getRegisterLineName();
            String startStationName = LineRetryInput.getRegisterLineStartStationName();
            String endStationName = LineRetryInput.getRegisterLineEndStationName();
            lineService.register(new LineRegisterInputDto(lineName, startStationName, endStationName));
        }
        if (lineCommand == LineCommand.REMOVE) {
            String lineName = LineRetryInput.getRemoveLineName();
            lineService.remove(new LineRemoveInputDto(lineName));
            OutputView.printLineRemovedMessage();
        }
        if (lineCommand == LineCommand.RETRIEVE) {
            List<LineDto> lines = lineService.retrieve().lines();
            OutputView.printLines(lines);
        }
    }

    private void sectionLogic(SectionCommand sectionCommand) {
        if (sectionCommand == SectionCommand.BACK) {
            return;
        }

        if (sectionCommand == SectionCommand.REGISTER) {
            String lineName = SectionRetryInput.getLineName();
            SectionRetryInput.getStationName();
            SectionRetryInput.getOrderNumber();
        }
        if (sectionCommand == SectionCommand.REMOVE) {
            SectionRetryInput.getRemoveLineName();
            SectionRetryInput.getRemoveStationName();
        }
    }
}
