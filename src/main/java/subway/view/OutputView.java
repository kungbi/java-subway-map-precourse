package subway.view;

import java.util.Arrays;
import java.util.List;
import subway.command.LineCommand;
import subway.command.MainCommand;
import subway.command.SectionCommand;
import subway.command.StationCommand;
import subway.dto.LineDto;
import subway.dto.StationDto;

public class OutputView {
    public static void printMainMenu() {
        System.out.println("## 메인 화면");
        Arrays.stream(MainCommand.values()).forEach(
                command -> System.out.printf("%s. %s\n", command.getCommand(), command.getDescription())
        );
        System.out.println();
    }

    public static void printStationManageMenu() {
        System.out.println("## 역 관리 화면");
        Arrays.stream(StationCommand.values()).forEach(
                command -> System.out.printf("%s. %s\n", command.getCommand(), command.getDescription())
        );
        System.out.println();
    }

    public static void printLineManageMenu() {
        System.out.println("## 노선 관리 화면");
        Arrays.stream(LineCommand.values()).forEach(
                command -> System.out.printf("%s. %s\n", command.getCommand(), command.getDescription())
        );
        System.out.println();
    }

    public static void printSectionManageMenu() {
        System.out.println("## 구간 관리 화면");
        Arrays.stream(SectionCommand.values()).forEach(
                command -> System.out.printf("%s. %s\n", command.getCommand(), command.getDescription())
        );
        System.out.println();
    }

    public static void printStations(List<StationDto> stations) {
        System.out.println("## 역 목록");
        stations.forEach((station) -> printInfo(station.name()));
        System.out.println();
    }

    public static void printLines(List<LineDto> lines) {
        System.out.println("## 노선 목록");
        lines.forEach((line) -> printInfo(line.name()));
        System.out.println();
    }

    public static void printLineMap(List<LineDto> lines) {
        System.out.println("## 지하철 노선도");
        for (LineDto line : lines) {
            printInfo(line.name());
            printInfo("---");
            line.stations().forEach(station -> printInfo(station.name()));
        }
    }

    public static void printStationRemovedMessage() {
        printInfo("지하철 역이 삭제되었습니다.");
    }

    public static void printLineRemovedMessage() {
        printInfo("지하철 노선이 삭제되었습니다.");
    }

    public static void printSectionRemovedMessage() {
        printInfo("구간이 삭제되었습니다.");
    }

    public static void printInfo(String message) {
        System.out.println("[INFO] " + message);
    }

    public static void printError(String message) {
        System.out.println("[ERROR] " + message);
        System.out.println();
    }
}
