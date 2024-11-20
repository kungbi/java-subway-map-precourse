package subway.command;

public interface Command {
    static <T extends Command> T findCommand(String input, T[] commands) {
        for (T command : commands) {
            if (command.getCommand().equals(input)) {
                return command;
            }
        }
        throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
    }

    String getCommand();

    String getDescription();
}
