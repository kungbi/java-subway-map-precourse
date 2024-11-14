package subway.controller.retryInputUtil;

import subway.command.LineCommand;
import subway.validator.InputValidator;
import subway.view.InputView;
import subway.view.LineInputView;

public class LineRetryInput {

    public static String getCommand() {
        return RetryInputUtil.retryLogics(InputView::getCommand, LineCommand::find);
    }

    public static String getRegisterLineName() {
        return RetryInputUtil.retryLogics(LineInputView::getRegisterLineName, InputValidator::nullValidate);
    }

    public static String getRegisterLineStartStationName() {
        return RetryInputUtil.retryLogics(LineInputView::getRegisterLineStartStationName, InputValidator::nullValidate);
    }

    public static String getRegisterLineEndStationName() {
        return RetryInputUtil.retryLogics(LineInputView::getRegisterLineEndStationName, InputValidator::nullValidate);
    }

    public static String getRemoveLineName() {
        return RetryInputUtil.retryLogics(LineInputView::getRemoveLineName, InputValidator::nullValidate);
    }
}
