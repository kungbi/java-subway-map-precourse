package subway.command;

public enum SectionCommand {
    REGISTER("1", "구간 등록"),
    REMOVE("2", "구간 삭제"),
    BACK("B", "돌아가기");

    private final String command;
    private final String description;

    SectionCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static SectionCommand find(String input) {
        for (SectionCommand sectionCommand : SectionCommand.values()) {
            if (sectionCommand.command.equals(input)) {
                return sectionCommand;
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
