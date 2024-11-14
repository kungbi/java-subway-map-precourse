package subway.view;

public class InputView {

    // 기능 선택 유저 입력 함수
    public String getCommand() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return getUserInput();
    }

    // 정류장 관련 입력 함수들
    public String getRegisterStationName() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        return getUserInput();
    }

    public String getRemoveStationName() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        return getUserInput();
    }

    // 노선 관련 입력 함수들
    public String getRegisterLineName() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        return getUserInput();
    }

    public String getRegisterLineStartStationName() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        return getUserInput();
    }

    public String getRegisterLineEndStationName() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        return getUserInput();
    }

    public String getRemoveLineName() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        return getUserInput();
    }

    // 구간 관련 입력 함수들

    public String getLineName() {
        System.out.println("## 노선을 입력하세요.");
        return getUserInput();
    }

    public String getStationName() {
        System.out.println("## 역이름을 입력하세요.");
        return getUserInput();
    }

    public String getOrderNumber() {
        System.out.println("## 순서를 입력하세요.");
        return getUserInput();
    }

    public String getRemoveSectionName() {
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
        return getUserInput();
    }

    // 유저 입력 받기 함수
    private String getUserInput() {
        System.out.print("> ");
        String input = Console.readline();
        System.out.println();
        return input;
    }
}
