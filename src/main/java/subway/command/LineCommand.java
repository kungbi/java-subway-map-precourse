package subway.command;

public enum LineCommand {
    REGISTER("1", "노선 등록"),
    REMOVE("2", "노선 삭제"),
    SEARCH("3", "노선 조회"),
    BACK("B", "돌아가기");

    private final String command;
    private final String description;

    LineCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static LineCommand find(String input) {
        for (LineCommand lineCommand : LineCommand.values()) {
            if (lineCommand.command.equals(input)) {
                return lineCommand;
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
