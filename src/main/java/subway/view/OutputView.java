package subway.view;

import java.util.List;
import subway.dto.LineDto;
import subway.dto.StationDto;

public class OutputView {
    public static void printMainMenu() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
        System.out.println();
    }

    public static void printStationManageMenu() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
        System.out.println();
    }

    public static void printLineManageMenu() {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
        System.out.println();
    }

    public static void printSectionManageMenu() {
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
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
