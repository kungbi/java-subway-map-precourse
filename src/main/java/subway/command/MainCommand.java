package subway.command;

public enum MainCommand implements Command {
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

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
