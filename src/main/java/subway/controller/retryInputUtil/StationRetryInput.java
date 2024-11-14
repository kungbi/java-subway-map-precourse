package subway.controller.retryInputUtil;

import subway.command.StationCommand;
import subway.validator.InputValidator;
import subway.view.InputView;
import subway.view.StationInputView;

public class StationRetryInput {

    public static String getCommand() {
        return RetryInputUtil.retryLogics(InputView::getCommand, StationCommand::find);
    }

    public static String getStationName() {
        return RetryInputUtil.retryLogics(StationInputView::getRegisterStationName, InputValidator::nullValidate);
    }

    public static String getRemoveStationName() {
        return RetryInputUtil.retryLogics(StationInputView::getRemoveStationName, InputValidator::nullValidate);
    }
}
