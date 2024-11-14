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

    public String getRegisterStationName() {
        return retryLogics(inputView::getRegisterStationName, InputValidator::nullValidate);
    }

    public String getRemoveStationName() {
        return retryLogics(inputView::getRemoveStationName, InputValidator::nullValidate);
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
