package subway.controller.retryInputUtil;

import subway.command.Command;
import subway.command.StationCommand;
import subway.validator.InputValidator;
import subway.view.InputView;
import subway.view.StationInputView;

public class StationRetryInput {

    public static String getCommand() {
        return RetryInputUtil.retryLogics(InputView::getCommand,
                (input) -> Command.findCommand(input, StationCommand.values()));
    }

    public static String getStationName() {
        return RetryInputUtil.retryLogics(StationInputView::getRegisterStationName, InputValidator::nullValidate);
    }

    public static String getRemoveStationName() {
        return RetryInputUtil.retryLogics(StationInputView::getRemoveStationName, InputValidator::nullValidate);
    }
}
