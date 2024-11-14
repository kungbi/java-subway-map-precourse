package subway.command;

public enum StationCommand {
    REGISTER("1", "역 등록"),
    REMOVE("2", "역 삭제"),
    SEARCH("3", "역 조회"),
    BACK("B", "역 조회");


    private final String command;
    private final String description;

    StationCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static StationCommand find(String input) {
        for (StationCommand stationCommand : StationCommand.values()) {
            if (stationCommand.command.equals(input)) {
                return stationCommand;
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
