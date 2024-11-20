package subway.command;

public enum LineCommand implements Command {
    REGISTER("1", "노선 등록"),
    REMOVE("2", "노선 삭제"),
    RETRIEVE("3", "노선 조회"),
    BACK("B", "돌아가기");

    private final String command;
    private final String description;

    LineCommand(String command, String description) {
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
