package subway.command;

public enum SectionCommand implements Command {
    REGISTER("1", "구간 등록"),
    REMOVE("2", "구간 삭제"),
    BACK("B", "돌아가기");

    private final String command;
    private final String description;

    SectionCommand(String command, String description) {
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
