package subway.controller;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import subway.command.LineCommand;
import subway.command.MainCommand;
import subway.command.SectionCommand;
import subway.command.StationCommand;
import subway.validator.InputValidator;
import subway.view.InputView;
import subway.view.OutputView;

public class RetryInputUtil {
    public static final Function<String, String> NONE = (command) -> command;
    private final InputView inputView;
    private final OutputView outputView;

    public RetryInputUtil(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    // 메뉴 선택

    public String getMainCommand() {
        return retryLogics(inputView::getCommand, MainCommand::find);
    }

    public String getStationCommand() {
        return retryLogics(inputView::getCommand, StationCommand::find);
    }

    public String getLineCommand() {
        return retryLogics(inputView::getCommand, LineCommand::find);
    }

    public String getSectionCommand() {
        return retryLogics(inputView::getCommand, SectionCommand::find);
    }

    // 정류장 관련

    public String getRegisterStationName() {
        return retryLogics(inputView::getRegisterStationName, InputValidator::nullValidate);
    }

    public String getRemoveStationName() {
        return retryLogics(inputView::getRemoveStationName, InputValidator::nullValidate);
    }

    // 노선 관련

    public String getRegisterLineName() {
        return retryLogics(inputView::getRegisterLineName, InputValidator::nullValidate);
    }

    public String getRegisterLineStartStationName() {
        return retryLogics(inputView::getRegisterLineStartStationName, InputValidator::nullValidate);
    }

    public String getRegisterLineEndStationName() {
        return retryLogics(inputView::getRegisterLineEndStationName, InputValidator::nullValidate);
    }

    public String getRemoveLineName() {
        return retryLogics(inputView::getRemoveLineName, InputValidator::nullValidate);
    }

    // 구간 관련

    public String getLineName() {
        return retryLogics(inputView::getLineName, InputValidator::nullValidate);
    }

    public String getStationName() {
        return retryLogics(inputView::getStationName, InputValidator::nullValidate);
    }

    public String getOrderNumber() {
        return retryLogics(inputView::getOrderNumber, InputValidator::nullValidate);
    }

    public String getRemoveSectionName() {
        return retryLogics(inputView::getRemoveSectionName, InputValidator::nullValidate);
    }

    private <T> T retryLogics(Supplier<String> userInputReader, Function<String, T> parser, Consumer<T> validator) {
        while (true) {
            try {
                String userInput = userInputReader.get();
                T parsedInput = parser.apply(userInput);
                validator.accept(parsedInput);
                return parsedInput;
            } catch (IllegalArgumentException error) {
                outputView.printError(error.getMessage());
            }
            retryLogics(userInputReader, parser, validator);

        }
    }

    private String retryLogics(Supplier<String> userInputReader, Consumer<String> validator) {
        while (true) {
            try {
                String userInput = userInputReader.get();
                validator.accept(userInput);
                return userInput;
            } catch (IllegalArgumentException error) {
                outputView.printError(error.getMessage());
            }

        }
    }
}
