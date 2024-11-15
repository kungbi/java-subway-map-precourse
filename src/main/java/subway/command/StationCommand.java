package subway.command;

public enum StationCommand implements Command {
    REGISTER("1", "역 등록"),
    REMOVE("2", "역 삭제"),
    RETRIEVE("3", "역 조회"),
    BACK("B", "돌아가기");


    private final String command;
    private final String description;

    StationCommand(String command, String description) {
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
