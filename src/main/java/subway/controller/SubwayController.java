package subway.controller;

import subway.command.LineCommand;
import subway.command.MainCommand;
import subway.command.SectionCommand;
import subway.command.StationCommand;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RetryInputUtil retryInputUtil;


    public SubwayController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.retryInputUtil = new RetryInputUtil(inputView, outputView);
    }

    public void run() {
        int state = 0;

        while (state == 0) {
            outputView.printMainMenu();
            MainCommand mainCommand = MainCommand.find(retryInputUtil.getMainCommand());

            state = mainLogic(mainCommand);
        }
    }

    private int mainLogic(MainCommand mainCommand) {
        if (mainCommand == MainCommand.QUIT) {
            return 1;
        }

        if (mainCommand == MainCommand.STATION) {
            outputView.printStationManageMenu();
            StationCommand stationCommand = StationCommand.find(retryInputUtil.getStationCommand());
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


}
