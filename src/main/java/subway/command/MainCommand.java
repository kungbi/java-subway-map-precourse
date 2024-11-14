package subway.command;

public enum MainCommand {
    STATION("1", "역 관리 "),
    LINE("2", "노선 관리"),
    SECTION("3", "구간 관리"),
    LINE_PRINT("4", "지하철 노선도 출력"),
    QUIT("Q", "종료");

    private final String command;
    private final String description;

    MainCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static MainCommand find(String input) {
        for (MainCommand mainCommand : MainCommand.values()) {
            if (mainCommand.command.equals(input)) {
                return mainCommand;
            }
        }
        throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }
}
