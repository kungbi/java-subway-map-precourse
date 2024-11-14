package subway.controller.retryInputUtil;

import subway.command.SectionCommand;
import subway.controller.InputParser;
import subway.validator.InputValidator;
import subway.view.InputView;
import subway.view.SectionInputView;

public class SectionRetryInput {

    public static String getCommand() {
        return RetryInputUtil.retryLogics(InputView::getCommand, SectionCommand::find);
    }

    public static String getLineName() {
        return RetryInputUtil.retryLogics(SectionInputView::getLineName, InputValidator::nullValidate);
    }

    public static String getStationName() {
        return RetryInputUtil.retryLogics(SectionInputView::getStationName, InputValidator::nullValidate);
    }

    public static int getOrderNumber() {
        return RetryInputUtil.retryLogics(SectionInputView::getOrderNumber, InputParser::parseInt,
                InputValidator::orderNumberValidate);
    }

    public static String getRemoveLineName() {
        return RetryInputUtil.retryLogics(SectionInputView::getRemoveLineName, InputValidator::nullValidate);
    }

    public static String getRemoveStationName() {
        return RetryInputUtil.retryLogics(SectionInputView::getRemoveStationName, InputValidator::nullValidate);
    }
}
