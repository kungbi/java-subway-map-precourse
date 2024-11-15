package subway.controller.retryInputUtil;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import subway.command.Command;
import subway.command.MainCommand;
import subway.view.InputView;
import subway.view.OutputView;

public class RetryInputUtil {

    public static String getMainCommand() {
        return retryLogics(InputView::getCommand, (input) -> Command.findCommand(input, MainCommand.values()));
    }

    public static <T> T retryLogics(Supplier<String> userInputReader, Function<String, T> parser,
                                    Consumer<T> validator) {
        while (true) {
            try {
                String userInput = userInputReader.get();
                T parsedInput = parser.apply(userInput);
                validator.accept(parsedInput);
                return parsedInput;
            } catch (IllegalArgumentException error) {
                OutputView.printError(error.getMessage());
            }
            retryLogics(userInputReader, parser, validator);

        }
    }

    public static String retryLogics(Supplier<String> userInputReader, Consumer<String> validator) {
        while (true) {
            try {
                String userInput = userInputReader.get();
                validator.accept(userInput);
                return userInput;
            } catch (IllegalArgumentException error) {
                OutputView.printError(error.getMessage());
            }

        }
    }
}
