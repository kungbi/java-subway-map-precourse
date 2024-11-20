package subway.controller.handler;

import java.util.List;
import subway.command.Command;
import subway.command.LineCommand;
import subway.controller.retryInputUtil.LineRetryInput;
import subway.dto.LineDto;
import subway.dto.LineRegisterDto.LineRegisterInputDto;
import subway.dto.LineRemoveDto.LineRemoveInputDto;
import subway.service.LineService;
import subway.view.OutputView;

public class LineHandler implements Handler {
    private final LineService lineService;

    public LineHandler(LineService lineService) {
        this.lineService = lineService;
    }

    @Override
    public void handle() {
        OutputView.printLineManageMenu();
        LineCommand lineCommand = Command.findCommand(LineRetryInput.getCommand(), LineCommand.values());

        if (lineCommand == LineCommand.REGISTER) {
            registerLine();
        }
        if (lineCommand == LineCommand.REMOVE) {
            removeLine();
        }
        if (lineCommand == LineCommand.RETRIEVE) {
            retrieveLine();
        }
        if (lineCommand == LineCommand.BACK) {
            // nothing to do.
        }

    }

    private void registerLine() {
        String lineName = LineRetryInput.getRegisterLineName();
        String startStationName = LineRetryInput.getRegisterLineStartStationName();
        String endStationName = LineRetryInput.getRegisterLineEndStationName();
        lineService.register(new LineRegisterInputDto(lineName, startStationName, endStationName));
    }

    private void removeLine() {
        String lineName = LineRetryInput.getRemoveLineName();
        lineService.remove(new LineRemoveInputDto(lineName));
        OutputView.printLineRemovedMessage();
    }

    private void retrieveLine() {
        List<LineDto> lines = lineService.retrieve().lines();
        OutputView.printLines(lines);
    }
}
