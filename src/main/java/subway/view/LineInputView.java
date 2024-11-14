package subway.view;

public class LineInputView {

    public static String getRegisterLineName() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        return InputView.getUserInput();
    }

    public static String getRegisterLineStartStationName() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        return InputView.getUserInput();
    }

    public static String getRegisterLineEndStationName() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        return InputView.getUserInput();
    }

    public static String getRemoveLineName() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        return InputView.getUserInput();
    }
}
