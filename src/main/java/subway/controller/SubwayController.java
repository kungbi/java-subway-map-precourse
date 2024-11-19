package subway.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.command.Command;
import subway.command.MainCommand;
import subway.controller.handler.Handler;
import subway.controller.handler.LineHandler;
import subway.controller.handler.SectionHandler;
import subway.controller.handler.StationHandler;
import subway.controller.retryInputUtil.RetryInputUtil;
import subway.dto.LineDto;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;
import subway.view.OutputView;

public class SubwayController {
    private final LineService lineService;
    private final Map<MainCommand, Handler> commandHandlers;

    public SubwayController(StationService stationService, LineService lineService, SectionService sectionService) {
        this.lineService = lineService;

        this.commandHandlers = new HashMap<>();
        this.commandHandlers.put(MainCommand.STATION, new StationHandler(stationService));
        this.commandHandlers.put(MainCommand.LINE, new LineHandler(lineService));
        this.commandHandlers.put(MainCommand.SECTION, new SectionHandler(sectionService));
    }

    public void run() {
        int state = 0;

        while (state == 0) {
            try {
                OutputView.printMainMenu();
                MainCommand mainCommand = Command.findCommand(RetryInputUtil.getMainCommand(), MainCommand.values());

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

        if (this.commandHandlers.containsKey(mainCommand)) {
            this.commandHandlers.get(mainCommand).handle();
        }
        if (mainCommand == MainCommand.LINE_PRINT) {
            printLineMap();
        }

        return 0;
    }

    private void printLineMap() {
        List<LineDto> lines = lineService.retrieve().lines();
        OutputView.printLineMap(lines);
    }

}
